package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> searchName(String name, String email, Pageable pageable) {
        return employeeRepository.searchName(name,email,pageable);
    }

    @Override
    public boolean add(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }


}
