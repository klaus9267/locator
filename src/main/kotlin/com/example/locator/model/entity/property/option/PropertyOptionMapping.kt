package com.example.locator.model.entity.property.option

import com.example.locator.model.entity.property.BaseProperty
import jakarta.persistence.*

@Entity
@Table
class PropertyOptionMapping(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val property: BaseProperty,

    @ManyToOne(fetch = FetchType.LAZY)
    val option: Option,
)