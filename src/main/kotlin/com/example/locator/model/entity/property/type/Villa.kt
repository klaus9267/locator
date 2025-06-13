package com.example.locator.model.entity.property.type

import com.example.locator.model.entity.property.BaseProperty
import com.example.locator.model.entity.property.embed.Address
import com.example.locator.model.entity.property.embed.AreaInfo
import com.example.locator.model.entity.property.embed.Location
import com.example.locator.model.entity.property.enums.PropertyType
import com.example.locator.model.entity.property.enums.RoomType
import com.example.locator.model.entity.property.enums.TransactionType
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table
class Villa(
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
    val roomType: RoomType? = null, // 방 타입 (투룸, 쓰리룸 등)

    @Column
    val bathroomCount: String? = null, // 화장실 개수

    @Column
    val residenceType: String? = null // 거주 형태 (단독주택, 다세대주택 등)
) : BaseProperty(
    propertyType = PropertyType.VILLA,
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