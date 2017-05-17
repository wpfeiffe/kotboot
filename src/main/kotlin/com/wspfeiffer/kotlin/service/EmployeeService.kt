package com.wspfeiffer.kotlin.service

import com.wspfeiffer.kotlin.domain.Employee
import com.wspfeiffer.kotlin.repository.EmployeeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.Query

/**
 * Service for Customer entity
 */
@Service
@Transactional
class EmployeeService(val employeeRepository: EmployeeRepository, val entityManager: EntityManager) {

    fun getEmployees() : List<Employee> {
//        val employeQuery: Query = entityManager.createQuery("select employee from Employee as employee")
//        val employeeQueryList: List<Employee> = employeQuery.getResultList() as List<Employee>

        val employeeList: List<Employee> = employeeRepository.findAll()
        return employeeList
    }

    fun getEmployee(id: Long): Employee {
        return employeeRepository.getOne(id)
    }
    
    fun saveEmployee(employee: Employee): Employee {
        val updatedEmployee = employeeRepository.save(employee)
        return updatedEmployee
    }

    fun deleteEmployee(id: Long): Employee {
        val deletedEmployee: Employee = employeeRepository.getOne(id)
        employeeRepository.delete(id)
        return deletedEmployee
    }
}
