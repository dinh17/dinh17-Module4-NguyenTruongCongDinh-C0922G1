package com.example.onthi3.service;


import com.example.onthi3.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> searchName(String name, String email, Pageable pageable);
     boolean add(Employee employee);
    void remove(int id);
    boolean edit(Employee employee);

}
