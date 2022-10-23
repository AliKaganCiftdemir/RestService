package com.example.RestService.business.concretes;

import com.example.RestService.business.abstracts.EmployeeService;
import com.example.RestService.dataAccess.EmployeeRepository;
import com.example.RestService.entity.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public Employee saveEmployees(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return this.employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findEmployeeEmailByKeyword(String keyword) {
        return this.employeeRepository.findByEmailContaining(keyword);
    }

}
