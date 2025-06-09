package com.example.locator.controller

import com.example.locator.service.ApartmentCatalogResponse
import com.example.locator.service.CrawlService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/crawls")
class CrawlController(
    private val crawlService: CrawlService
) {

    @PostMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    fun crawlApartments(): ApartmentCatalogResponse = crawlService.crawlApartments()
}