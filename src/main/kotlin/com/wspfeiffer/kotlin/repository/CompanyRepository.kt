package com.wspfeiffer.kotlin.repository

import com.wspfeiffer.kotlin.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Spring JPA Repository for Customer
 */
interface CompanyRepository : JpaRepository<Company, Long>{
    fun findByCompanyName(companyName: String)
}