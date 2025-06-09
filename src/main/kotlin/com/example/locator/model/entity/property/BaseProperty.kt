package com.example.locator.model.entity.property

import com.example.locator.model.entity.property.embed.Address
import com.example.locator.model.entity.property.embed.AreaInfo
import com.example.locator.model.entity.property.embed.Location
import com.example.locator.model.entity.property.enums.PropertyType
import com.example.locator.model.entity.property.enums.TransactionType
import com.example.locator.model.entity.property.option.PropertyOptionMapping
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "properties")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener::class)
@DiscriminatorColumn(name = "property_type")
abstract class BaseProperty(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0, // PK

    @Column(unique = true, nullable = false)
    val zigbangItemId: Long, // 직방 매물 고유 ID

    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    val propertyType: PropertyType, // 매물 타입 (아파트/오피스텔/원룸/빌라)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType, // 거래 타입 (매매/전세/월세)

    @Column(nullable = false)
    val title: String, // 매물 제목

    @Column(columnDefinition = "TEXT")
    val description: String? = null, // 매물 상세 설명

    @Column(nullable = false)
    val deposit: Long, // 보증금 (단위: 만원)

    @Column
    val monthlyRent: Long? = null, // 월세 (단위: 만원, 전세/매매시 null)

    @Embedded
    val location: Location, // 위치 정보 (위도/경도)

    @Embedded
    val address: Address, // 주소 정보

    @Embedded
    val areaInfo: AreaInfo, // 면적 정보

    @Column
    val floorInfo: String? = null, // 층수 정보 (예: "5", "옥탑방", "반지하")

    @Column
    val buildingFloor: String? = null, // 건물 총 층수

    @Column
    val roomDirection: String? = null, // 방향 (남향, 동향 등)

    @Column
    val moveinDate: String? = null, // 입주 가능일

    @Column
    val managementCost: Int? = null, // 관리비 (단위: 만원)

    @Column
    val parkingAvailable: Boolean = false, // 주차 가능 여부

    @Column
    val elevatorAvailable: Boolean = false, // 엘리베이터 유무

    @Column
    val thumbnailUrl: String? = null, // 대표 이미지 URL

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val options: MutableList<PropertyOptionMapping> = mutableListOf()
}