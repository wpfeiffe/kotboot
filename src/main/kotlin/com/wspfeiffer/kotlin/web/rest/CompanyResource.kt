package com.wspfeiffer.kotlin.web.rest

import com.wspfeiffer.kotlin.domain.Company
import com.wspfeiffer.kotlin.service.CompanyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Company rest resource
 */

@RestController
@RequestMapping("/api")
class CompanyController (val companyService: CompanyService) {
    val returnValue = "Hello Kotboot"

    @RequestMapping("/companies")
    fun getCompanies() : ResponseEntity<List<Company>> {
        val companyList: List<Company> = companyService.getCompanies();
        return ResponseEntity(companyList, HttpStatus.OK)
    }

    @RequestMapping("/companies/{id}")
    fun getCompany(@PathVariable id: Long): ResponseEntity<Company> {
        val company: Company = companyService.getCompany(id)
        return ResponseEntity(company, HttpStatus.OK)
    }


}