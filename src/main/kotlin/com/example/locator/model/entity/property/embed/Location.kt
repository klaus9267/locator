package com.example.locator.model.entity.property.embed

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Location(
    @Column(name = "latitude")
    val latitude: Double, // 위도

    @Column(name = "longitude")
    val longitude: Double // 경도
) {
    init {
        require(latitude in -90.0..90.0) {
            "위도는 -90 ~ 90 사이여야 합니다"
        }
        require(longitude in -180.0..180.0) {
            "경도는 -180 ~ 180 사이여야 합니다"
        }
    }
}