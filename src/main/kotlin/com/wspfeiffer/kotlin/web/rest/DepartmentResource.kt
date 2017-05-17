package com.wspfeiffer.kotlin.web.rest

import com.wspfeiffer.kotlin.domain.Department
import com.wspfeiffer.kotlin.service.DepartmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Department rest resource
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
class DepartmentController(val departmentService: DepartmentService) {

    @RequestMapping(value = "/departments", method = arrayOf(RequestMethod.GET))
    fun getDepartments(): ResponseEntity<List<Department>> {
        val departmentList: List<Department> = departmentService.getDepartments()
        return ResponseEntity(departmentList, HttpStatus.OK)
    }

    @RequestMapping(value = "/departments/{id}", method = arrayOf(RequestMethod.GET))
    fun getDepartment(@PathVariable id: Long): ResponseEntity<Department> {
        val department = departmentService.getDepartment(id)
        return ResponseEntity(department, HttpStatus.OK)
    }

    @RequestMapping(value = "/departments", params = arrayOf("name"), method = arrayOf(RequestMethod.GET))
    fun getDepartmentByName(@RequestParam("name") deptName: String): ResponseEntity<Department> {
        val department = departmentService.getDepartmentByName(deptName)
        if (department != null)
        {
            return ResponseEntity(department, HttpStatus.OK)
        }
        else
        {
            return ResponseEntity(null, HttpStatus.NOT_FOUND)
        }
    }
    @RequestMapping(value = "/departments", params = arrayOf("code"), method = arrayOf(RequestMethod.GET))
    fun getDepartmentByCode(@RequestParam("code") deptCode: String): ResponseEntity<Department> {
        val department = departmentService.getDepartmentByCode(deptCode)
        if (department != null)
        {
            return ResponseEntity(department, HttpStatus.OK)
        }
        else
        {
            return ResponseEntity(null, HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/departments/{id}")
    fun deleteDepartment(@PathVariable id: Long): ResponseEntity<Department> {
        val department: Department = departmentService.deleteDepartment(id)
        return ResponseEntity(department, HttpStatus.OK)

    }

    @PutMapping("/departments")
    fun updateDepartment(@RequestBody department: Department): ResponseEntity<Department>  {
        val returnDepartment: Department = departmentService.saveDepartment(department)
        return ResponseEntity(returnDepartment, HttpStatus.OK)
    }
    

}
