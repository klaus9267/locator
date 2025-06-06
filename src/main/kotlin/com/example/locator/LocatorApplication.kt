package com.example.locator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransitApplication

fun main(args: Array<String>) {
	runApplication<TransitApplication>(*args)
}
