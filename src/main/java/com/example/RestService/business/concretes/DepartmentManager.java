package com.example.RestService.business.concretes;

import com.example.RestService.business.abstracts.DepartmentService;
import com.example.RestService.dataAccess.DepartmentRepository;
import com.example.RestService.entity.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentManager implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        }
        throw new RuntimeException("Department is not found for the id " + id);
    }

    @Override
    public Department saveDepartments(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> findDepartmentByName(String name) {
        return this.departmentRepository.findByDepartmentName(name);
    }
}
