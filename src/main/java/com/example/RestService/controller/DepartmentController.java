package com.example.RestService.controller;

import com.example.RestService.business.abstracts.DepartmentService;
import com.example.RestService.entity.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("departments")
    public List<Department> getAllDepartments() {
        return this.departmentService.findAllDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable(value = "id") Long id) {
        return this.departmentService.findDepartmentById(id);
    }

    @PostMapping("departments")
    public Department saveDepartment(@RequestBody Department department) {
        return this.departmentService.saveDepartments(department);
    }

    @PutMapping("departments/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable(value = "id") Long id, @RequestBody Department departmentDetails){
        Department department = this.departmentService.findDepartmentById(id);

        department.setDepartmentName(departmentDetails.getDepartmentName());
        department.setEmployeeList(departmentDetails.getEmployeeList());

        return ResponseEntity.ok(this.departmentService.saveDepartments(department));
    }

    @DeleteMapping("departments/{id}")
    public void deleteDepartmentById(@PathVariable(value = "id") Long id) {
        this.departmentService.deleteDepartmentById(id);
    }

    @GetMapping("departments/filterByName")
    public List<Department> getAllDepartmentsByName(@RequestParam String name) {
        return this.departmentService.findDepartmentByName(name);
    }

}
