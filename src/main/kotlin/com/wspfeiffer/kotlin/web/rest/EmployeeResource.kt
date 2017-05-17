package com.wspfeiffer.kotlin.web.rest

import com.wspfeiffer.kotlin.domain.Company
import com.wspfeiffer.kotlin.domain.Employee
import com.wspfeiffer.kotlin.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Employee> {
        val employee: Employee = employeeService.deleteEmployee(id)
        return ResponseEntity(employee, HttpStatus.OK)

    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee): ResponseEntity<Employee>  {
        val returnEmployee: Employee = employeeService.saveEmployee(employee)
        return ResponseEntity(returnEmployee, HttpStatus.OK)
    }
        
}