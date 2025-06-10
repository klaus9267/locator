package com.example.locator.model.repository

import com.example.locator.model.entity.property.BaseProperty
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyRepository : JpaRepository<BaseProperty, Long> {
}