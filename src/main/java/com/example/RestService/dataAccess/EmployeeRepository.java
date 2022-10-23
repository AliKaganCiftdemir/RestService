package com.example.RestService.dataAccess;

import com.example.RestService.entity.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Select * from employee where firstName = name
    List<Employee> findByName(String name);

    //Select * from employee where email like "keyword"
    List<Employee> findByEmailContaining(String keyword);

}
