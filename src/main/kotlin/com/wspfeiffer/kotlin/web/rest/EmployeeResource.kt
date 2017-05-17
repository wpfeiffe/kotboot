package com.wspfeiffer.kotlin.web.rest

import com.wspfeiffer.kotlin.domain.Employee
import com.wspfeiffer.kotlin.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Employee rest resource
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
class EmployeeController (val employeeService: EmployeeService) {
    val returnValue = "Hello Kotboot"

    @RequestMapping("/employees")
    fun getEmployees() : ResponseEntity<List<Employee>> {
        val employeeList: List<Employee> = employeeService.getEmployees();
        return ResponseEntity(employeeList, HttpStatus.OK)
    }

    @RequestMapping("/employees/{id}")
    fun getEmployee(@PathVariable id: Long): ResponseEntity<Employee> {
        val employee: Employee = employeeService.getEmployee(id)
        return ResponseEntity(employee, HttpStatus.OK)
    }
}