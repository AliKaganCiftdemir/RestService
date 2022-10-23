package com.example.RestService.business.abstracts;

import com.example.RestService.entity.concretes.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findEmployeeById(Long id);
    Employee saveEmployees(Employee employee);
    List<Employee> findAllEmployees();
    void deleteEmployeeById(Long id);
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeEmailByKeyword(String keyword);

}
