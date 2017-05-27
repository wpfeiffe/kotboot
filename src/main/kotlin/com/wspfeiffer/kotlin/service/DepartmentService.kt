package com.wspfeiffer.kotlin.service

import com.wspfeiffer.kotlin.domain.Department
import com.wspfeiffer.kotlin.repository.DepartmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Service for Customer entity
 */
@Service
@Transactional
class DepartmentService(val departmentRepository: DepartmentRepository) {
    fun getDepartments(): List<Department> {
        return departmentRepository.findAll()
    }

    fun getDepartment(id: Long): Department {
        return departmentRepository.findOne(id)
    }

    fun getDepartmentByName(deptName: String): Department? {
        val deptList: List<Department> = departmentRepository.findByDeptName(deptName)
        var department: Department? = null
                if (deptList.size == 1) {
            department = deptList[0]
        }
        return department
    }

    fun getDepartmentByCode(deptCode: String): Department? {
        val deptList: List<Department> = departmentRepository.findByDeptCode(deptCode)
        var department: Department? = null
        if (deptList.size == 1) {
            department = deptList[0]
        }
        return department
    }
    fun saveDepartment(department: Department): Department {
        val updatedDepartment = departmentRepository.save(department)
        return updatedDepartment
    }

    fun deleteDepartment(id: Long): Department {
        val deletedDepartment: Department = departmentRepository.getOne(id)
        departmentRepository.delete(id)
        return deletedDepartment
    }
}
