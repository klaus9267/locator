package com.example.locator.model.entity.property.embed

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.math.BigDecimal
import java.math.RoundingMode

@Embeddable
data class AreaInfo(
    // 전용면적
    @Column(name = "exclusive_area_m2", precision = 8, scale = 2)
    val exclusiveArea: BigDecimal? = null,

    // 공급면적
    @Column(name = "supply_area_m2", precision = 8, scale = 2)
    val supplyArea: BigDecimal? = null,
) {
    companion object {
        private val PYEONG_CONVERSION = BigDecimal("3.3058")
    }

    fun getExclusiveAreaPyeong(): BigDecimal? {
        return exclusiveArea?.divide(PYEONG_CONVERSION, 1, RoundingMode.HALF_UP)
    }

    fun getSupplyAreaPyeong(): BigDecimal? {
        return supplyArea?.divide(PYEONG_CONVERSION, 1, RoundingMode.HALF_UP)
    }
}
