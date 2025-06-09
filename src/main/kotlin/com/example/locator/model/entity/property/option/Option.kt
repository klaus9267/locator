package com.example.locator.model.entity.property.option

import jakarta.persistence.*

@Entity
@Table(name = "options")
class Option(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val name: String, // "에어컨", "냉장고", "세탁기" 등
)