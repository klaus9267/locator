package com.example.locator.model.entity.property.embed

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(name = "local1")
    val local1: String? = null, // 시/도 (예: "경기도", "서울특별시")

    @Column(name = "local2")
    val local2: String? = null, // 시/군/구 (예: "용인시 수지구", "강남구")

    @Column(name = "local3")
    val local3: String? = null, // 읍/면/동 (예: "풍덕천동", "역삼동")

    @Column(name = "local4")
    val local4: String? = null, // 세부 지역 (있는 경우)

    @Column(name = "full_address")
    val fullAddress: String? = null, // 전체 주소

    @Column(name = "jibun_address")
    val jibunAddress: String? = null // 지번 주소
)
