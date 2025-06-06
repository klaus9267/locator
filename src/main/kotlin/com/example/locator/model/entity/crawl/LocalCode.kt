package com.example.locator.model.entity.crawl

enum class LocalCode(
    val region: String,
    val districtCode: Int
) {
    // 서울특별시 (25개 구)
    SEOUL_JONGNO("서울시 종로구", 11110),
    SEOUL_JUNG("서울시 중구", 11140),
    SEOUL_YONGSAN("서울시 용산구", 11170),
    SEOUL_SEONGDONG("서울시 성동구", 11200),
    SEOUL_GWANGJIN("서울시 광진구", 11215),
    SEOUL_DONGDAEMUN("서울시 동대문구", 11230),
    SEOUL_JUNGNANG("서울시 중랑구", 11260),
    SEOUL_SEONGBUK("서울시 성북구", 11290),
    SEOUL_GANGBUK("서울시 강북구", 11305),
    SEOUL_DOBONG("서울시 도봉구", 11320),
    SEOUL_NOWON("서울시 노원구", 11350),
    SEOUL_EUNPYEONG("서울시 은평구", 11380),
    SEOUL_SEODAEMUN("서울시 서대문구", 11410),
    SEOUL_MAPO("서울시 마포구", 11440),
    SEOUL_YANGCHEON("서울시 양천구", 11470),
    SEOUL_GANGSEO("서울시 강서구", 11500),
    SEOUL_GURO("서울시 구로구", 11530),
    SEOUL_GEUMCHEON("서울시 금천구", 11545),
    SEOUL_YEONGDEUNGPO("서울시 영등포구", 11560),
    SEOUL_DONGJAK("서울시 동작구", 11590),
    SEOUL_GWANAK("서울시 관악구", 11620),
    SEOUL_SEOCHO("서울시 서초구", 11650),
    SEOUL_GANGNAM("서울시 강남구", 11680),
    SEOUL_SONGPA("서울시 송파구", 11710),
    SEOUL_GANGDONG("서울시 강동구", 11740),

    // 경기도 - 수원시
    SUWON_JANGAN("수원시 장안구", 41111),
    SUWON_GWONSEON("수원시 권선구", 41113),
    SUWON_PALDAL("수원시 팔달구", 41115),
    SUWON_YEONGTONG("수원시 영통구", 41117),

    // 경기도 - 성남시
    SEONGNAM_SUJEONG("성남시 수정구", 41131),
    SEONGNAM_JUNGWON("성남시 중원구", 41133),
    SEONGNAM_BUNDANG("성남시 분당구", 41135),

    // 경기도 - 용인시
    YONGIN_CHEOIN("용인시 처인구", 41461),
    YONGIN_GIHEUNG("용인시 기흥구", 41463),
    YONGIN_SUJI("용인시 수지구", 41465),

    // 경기도 - 부천시
    BUCHEON("부천시", 41190),

    // 경기도 - 안양시
    ANYANG_MANAN("안양시 만안구", 41171),
    ANYANG_DONGAN("안양시 동안구", 41173),

    // 경기도 - 안산시
    ANSAN_DANWON("안산시 단원구", 41271),
    ANSAN_SANGNOK("안산시 상록구", 41273),

    // 경기도 - 고양시
    GOYANG_DEOGYANG("고양시 덕양구", 41281),
    GOYANG_ILSANDONG("고양시 일산동구", 41285),
    GOYANG_ILSANSEO("고양시 일산서구", 41287),

    // 경기도 - 남양주시
    NAMYANGJU("남양주시", 41360),

    // 경기도 - 시흥시
    SIHEUNG("시흥시", 41390),

    // 경기도 - 화성시
    HWASEONG("화성시", 41590),

    // 경기도 - 광명시
    GWANGMYEONG("광명시", 41210),

    // 경기도 - 군포시
    GUNPO("군포시", 41410),

    // 경기도 - 광주시
    GWANGJU("광주시", 41610),

    // 경기도 - 김포시
    GIMPO("김포시", 41570),

    // 경기도 - 이천시
    ICHEON("이천시", 41500),

    // 경기도 - 양주시
    YANGJU("양주시", 41630),

    // 경기도 - 구리시
    GURI("구리시", 41310),

    // 경기도 - 안성시
    ANSEONG("안성시", 41550),

    // 경기도 - 포천시
    POCHEON("포천시", 41650),

    // 경기도 - 의왕시
    UIWANG("의왕시", 41430),

    // 경기도 - 하남시
    HANAM("하남시", 41450),

    // 경기도 - 오산시
    OSAN("오산시", 41370),

    // 경기도 - 여주시
    YEOJU("여주시", 41670),

    // 경기도 - 양평군
    YANGPYEONG("양평군", 41830),

    // 경기도 - 동두천시
    DONGDUCHEON("동두천시", 41250),

    // 경기도 - 과천시
    GWACHEON("과천시", 41290),

    // 경기도 - 가평군
    GAPYEONG("가평군", 41820),

    // 경기도 - 연천군
    YEONCHEON("연천군", 41800),

    // 경기도 - 파주시
    PAJU("파주시", 41480),

    // 경기도 - 의정부시
    UIJEONGBU("의정부시", 41150);
}