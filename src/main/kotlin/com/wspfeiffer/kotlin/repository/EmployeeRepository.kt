package com.wspfeiffer.kotlin.repository

import com.wspfeiffer.kotlin.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Spring JPA Repository for Employee
 */
interface EmployeeRepository : JpaRepository<Employee, Long> {
}