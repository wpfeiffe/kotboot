package com.wspfeiffer.kotlin.service

import com.wspfeiffer.kotlin.domain.Company
import com.wspfeiffer.kotlin.repository.CompanyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Service for Customer entity
 */
@Service
@Transactional
class CompanyService(val companyRepository: CompanyRepository) {

    fun getCompanies() : List<Company> {
        return companyRepository.findAll()
    }

    fun getCompany(id: Long): Company {
        return companyRepository.getOne(id)
    }

    fun saveCompany(company: Company): Company {
        val updatedCompany = companyRepository.save(company)
        return updatedCompany
    }

    fun deleteCompany(id: Long): Company {
        val deletedCompany: Company = companyRepository.getOne(id)
        companyRepository.delete(id)
        return deletedCompany
    }
}
