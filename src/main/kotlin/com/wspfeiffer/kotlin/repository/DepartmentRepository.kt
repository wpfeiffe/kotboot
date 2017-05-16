package com.wspfeiffer.kotlin.repository

import com.wspfeiffer.kotlin.domain.Department
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Spring JPA Repository for Department
 */
interface DepartmentRepository : JpaRepository<Department, Long> {
    fun findByDeptName(deptName: String): List<Department>
    fun findByDeptCode(deptCode: String): List<Department>
}
