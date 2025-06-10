package com.example.locator.model.entity.property.type

import com.example.locator.model.entity.property.BaseProperty
import com.example.locator.model.entity.property.embed.Address
import com.example.locator.model.entity.property.embed.AreaInfo
import com.example.locator.model.entity.property.embed.Location
import com.example.locator.model.entity.property.enums.PropertyType
import com.example.locator.model.entity.property.enums.TransactionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table
class Apartment(
    zigbangItemId: Long,
    transactionType: TransactionType,
    title: String,
    description: String? = null,
    deposit: Long,
    monthlyRent: Long? = null,
    exclusiveArea: BigDecimal? = null,
    supplyArea: BigDecimal? = null,
    location: Location,
    address: Address,
    floorInfo: String? = null,
    buildingFloor: String? = null,
    roomDirection: String? = null,
    moveinDate: String? = null,
    managementCost: Int? = null,
    parkingAvailable: Boolean = false,
    elevatorAvailable: Boolean = false,
    thumbnailUrl: String? = null,

    @Column
    val complexId: Long? = null, // 아파트 단지 ID (직방 내부 ID)

    @Column
    val complexName: String? = null, // 아파트 단지명 (예: "래미안", "자이")

    @Column
    val dong: String? = null, // 동 정보 (예: "101동", "A동")

    @Column
    val roomTypeId: Long? = null, // 방 타입 ID (직방 내부 ID)

    @Column
    val roomCount: Int? = null, // 방 개수

    @Column
    val bathroomCount: Int? = null, // 화장실 개수

    @Column
    val approvalDate: String? = null, // 사용승인일

    @Column
    val householdCount: Int? = null // 총 세대수
) : BaseProperty(
    propertyType = PropertyType.APARTMENT,
    zigbangItemId = zigbangItemId,
    transactionType = transactionType,
    title = title,
    description = description,
    deposit = deposit,
    monthlyRent = monthlyRent,
    areaInfo = AreaInfo(exclusiveArea, supplyArea),
    location = location,
    address = address,
    floorInfo = floorInfo,
    buildingFloor = buildingFloor,
    roomDirection = roomDirection,
    moveinDate = moveinDate,
    managementCost = managementCost,
    parkingAvailable = parkingAvailable,
    elevatorAvailable = elevatorAvailable,
    thumbnailUrl = thumbnailUrl,
)