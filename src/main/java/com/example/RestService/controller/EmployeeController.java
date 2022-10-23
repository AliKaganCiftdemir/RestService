package com.example.RestService.controller;

import com.example.RestService.business.abstracts.EmployeeService;
import com.example.RestService.entity.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long id) {
        return this.employeeService.findEmployeeById(id);
    }

    @PostMapping("employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployees(employee);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long id, @RequestBody Employee employeeDetails) {
        Employee employee = this.employeeService.findEmployeeById(id);

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setCompany(employeeDetails.getCompany());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());

        return ResponseEntity.ok(this.employeeService.saveEmployees(employee));
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") Long id) {
        this.employeeService.deleteEmployeeById(id);
    }

    @GetMapping("employees/filterByName")
    public List<Employee> getAllEmployeesByName(@RequestParam String name) {
        return this.employeeService.findEmployeeByName(name);
    }

    @GetMapping("employees/filterByKeyword")
    public List<Employee> getAllEmployeesByKeyword(@RequestParam String keyword) {
        return this.employeeService.findEmployeeEmailByKeyword(keyword);
    }
}
