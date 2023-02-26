package com.example.case_study.service.impl;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.repository.IEmployeeRepository;
import com.example.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
