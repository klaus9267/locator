package com.example.locator.service

import com.example.locator.model.entity.crawl.LocalCode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import kotlin.random.Random

@Service
class CrawlService(
    private val objectMapper: ObjectMapper = jacksonObjectMapper()
) {
    private val logger = KotlinLogging.logger {}

    companion object {
        private const val BUILD_ID = "e8RgCa5EGUpkJvbRFfX8x" // 변경될 수 있음
        private val USER_AGENTS = listOf(
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36",
            "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36"
        )
    }

    private val apiWebClient = WebClient.builder()
        .baseUrl("https://apis.zigbang.com")
        .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENTS.random())
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT_LANGUAGE, "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
        .defaultHeader(HttpHeaders.REFERER, "https://www.zigbang.com/")
        .build()

    private val webWebClient = WebClient.builder()
        .baseUrl("https://www.zigbang.com")
        .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENTS.random())
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT_LANGUAGE, "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
        .build()

    fun crawlApartments(): ApartmentCatalogResponse {
        val initialResponse = sendCrawlApartmentsRequest(LocalCode.YONGIN_SUJI, 0)
        val totalCount = initialResponse.count

        logger.info { "총 매물 수: $totalCount" }

        val allItems = mutableListOf<ApartmentCatalogItem>()
        allItems.addAll(initialResponse.list)
        var offset = 10

        while (allItems.size < totalCount) {
            val response = sendCrawlApartmentsRequest(LocalCode.YONGIN_SUJI, offset)

            if (response.list.isEmpty()) break

            allItems.addAll(response.list)
            offset += 10

            if (allItems.size < totalCount) {
                Thread.sleep(Random.nextLong(500, 1500)) // 0.5~1.5초 랜덤 지연
            }
        }

        val finalResponse = ApartmentCatalogResponse(
            localCode = initialResponse.localCode,
            count = totalCount,
            list = allItems
        )

        logger.info { "크롤링 완료 - 총 ${finalResponse.count}개 중 ${finalResponse.list.size}개 매물 수집" }
        return finalResponse
    }

    private fun sendCrawlApartmentsRequest(
        localCode: LocalCode,
        offset: Int
    ) = apiWebClient.get()
        .uri { uriBuilder ->
            uriBuilder
                .path("/apt/locals/${localCode.districtCode}/item-catalogs")
                .queryParam("tranTypeIn[0]", "trade")
                .queryParam("tranTypeIn[1]", "charter")
                .queryParam("tranTypeIn[2]", "rental")
                .queryParam("includeOfferItem", true)
                .queryParam("offset", offset)
                .queryParam("limit", 10)
                .build()
        }
        .retrieve()
        .bodyToMono(ApartmentCatalogResponse::class.java)
        .block() ?: throw RuntimeException("응답이 null입니다")
}

// DTO 클래스들

// 위치 경계
data class LocationBounds(
    val lngEast: Double,
    val lngWest: Double,
    val latSouth: Double,
    val latNorth: Double
) {
    companion object {
        // 성복동 경계 좌표
        val SEONGBOK_DONG = LocationBounds(
            lngEast = 127.1521063223339,
            lngWest = 127.0354714009278,
            latSouth = 37.322114258081115,
            latNorth = 37.33283419206626
        )
    }
}

// 아파트 목록 응답
data class ApartmentCatalogResponse(
    val localCode: String,
    val count: Int,
    val list: List<ApartmentCatalogItem>
)

data class ApartmentCatalogItem(
    val areaHoId: Long,
    val tranType: String,
    val itemType: String,
    val areaDanjiId: Long,
    val areaDanjiName: String,
    val danjiRoomTypeId: Long,
    val local2: String,
    val local3: String,
    val depositMin: Int,
    val rentMin: Int,
    val roomTypeTitle: RoomTypeTitle,
    val sizeContractM2: Double,
    val sizeM2: Double,
    val dong: String,
    val floor: String,
    val itemTitle: String,
    val zzimCount: Int,
    val isZzim: Boolean,
    val isActualItemChecked: Boolean,
    val thumbnailUrl: String?,
    val itemCount: Int,
    val itemIdList: List<ItemId>,
    val agentThumbnailUrls: List<String>
)

data class RoomTypeTitle(
    val m2: String,
    val p: String
)

data class ItemId(
    val itemSource: String,
    val itemId: Long
)

// 아파트 상세 응답
data class ApartmentDetailResponse(
    val pageProps: PageProps
)

data class PageProps(
    val areaHoId: Long,
    val tranType: String,
    val items: List<DetailItem>
)

data class DetailItem(
    val id: Long,
    val deposit: Int,
    val rent: Int,
    val floor: String,
    val description: String
)

// 빌라/원룸 ID 수집 응답
data class VillaItemsResponse(
    val items: List<VillaItem>
)

data class OneroomItemsResponse(
    val items: List<OneroomItem>
)

data class VillaItem(
    val lat: Double,
    val lng: Double,
    val itemId: Long,
    val itemBmType: String
)

data class OneroomItem(
    val lat: Double,
    val lng: Double,
    val itemId: Long,
    val itemBmType: String
)

// 매물 상세 요청/응답
data class ItemsDetailRequest(
    val item_ids: List<Long>,
    val domain: String
)

data class ItemsDetailResponse(
    val items: List<ItemDetail>
)

data class ItemDetail(
    val item_id: Long,
    val sales_type: String,
    val deposit: Int,
    val rent: Int,
    val size_m2: Double,
    val title: String,
    val address: String,
    val floor: String? = null,
    val building_floor: String? = null,
    val room_type: String? = null,
    val service_type: String? = null
)

// 예외 클래스
class CrawlingException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)