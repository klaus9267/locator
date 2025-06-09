package com.example.locator.model.entity.property.option

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "options")
class Option(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0, // PK

    @Column( unique = true, nullable = false)
    val name: String, // "에어컨", "냉장고", "세탁기" 등
)