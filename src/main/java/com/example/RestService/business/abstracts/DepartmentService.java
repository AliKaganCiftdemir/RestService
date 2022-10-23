package com.example.RestService.business.abstracts;

import com.example.RestService.entity.concretes.Department;

import java.util.List;

public interface DepartmentService {

    Department findDepartmentById(Long id);
    Department saveDepartments(Department department);
    List<Department> findAllDepartments();
    void deleteDepartmentById(Long id);
    List<Department> findDepartmentByName(String name);

}
