package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> searchName(String name, String email, Pageable pageable);
     boolean add(Employee employee);
}
