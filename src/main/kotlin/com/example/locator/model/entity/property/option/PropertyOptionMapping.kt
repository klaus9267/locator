package com.example.locator.model.entity.property.option

import com.example.locator.model.entity.property.BaseProperty
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "property_option_mappings")
class PropertyOptionMapping(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val property: BaseProperty,

    @ManyToOne(fetch = FetchType.LAZY)
    val option: Option,
)