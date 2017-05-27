package com.wspfeiffer.kotlin.web.rest

import com.wspfeiffer.kotlin.domain.Company
import com.wspfeiffer.kotlin.service.CompanyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Company rest resource
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
class CompanyController (val companyService: CompanyService) {
    val returnValue = "Hello Kotboot"

    @GetMapping("/companies")
    fun getCompanies() : ResponseEntity<List<Company>> {
        val companyList: List<Company> = companyService.getCompanies();
        return ResponseEntity(companyList, HttpStatus.OK)
    }

    @GetMapping("/companies/{id}")
    fun getCompany(@PathVariable id: Long): ResponseEntity<Company> {
        val company: Company = companyService.getCompany(id)
        return ResponseEntity(company, HttpStatus.OK)
    }

    @DeleteMapping("/companies/{id}")
    fun deleteCompany(@PathVariable id: Long): ResponseEntity<Company> {
        val company: Company = companyService.deleteCompany(id)
        return ResponseEntity(company, HttpStatus.OK)

    }

    @PutMapping("/companies")
    fun updateCompany(@RequestBody company: Company): ResponseEntity<Company>  {
        val returnCompany: Company = companyService.saveCompany(company)
        return ResponseEntity(returnCompany, HttpStatus.OK)
    }

    @PostMapping("/companies")
    fun createCompany(@RequestBody company: Company): ResponseEntity<Company>  {
        val returnCompany: Company = companyService.saveCompany(company)
        return ResponseEntity(returnCompany, HttpStatus.OK)
    }
}