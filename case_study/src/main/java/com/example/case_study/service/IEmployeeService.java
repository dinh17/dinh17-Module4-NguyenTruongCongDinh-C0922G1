package com.example.case_study.service;


import com.example.case_study.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
