package com.example.onthi3.service.impl;

import com.example.onthi3.model.Employee;
import com.example.onthi3.repository.IEmployeeRepository;
import com.example.onthi3.service.IEmployeeService;
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
        return employeeRepository.searchName(name, email, pageable);
    }

    @Override
    public boolean add(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public boolean edit(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

}
