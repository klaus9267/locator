package com.example.locator.model.entity.property.enums


enum class TransactionType(val type: String) {
    SALE("매매"),
    MONTHLY_RENT("월세"),
    CHARTER("전세")
    ;

    companion object {
        fun fromString(value: String): TransactionType = when (value) {
            "trade", "매매" -> SALE
            "charter", "전세" -> CHARTER
            "rental", "월세" -> MONTHLY_RENT
            else -> throw IllegalArgumentException("Unknown transaction type: $value")
        }
    }
}
