package com.example.case_study.service;


import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> searchName(String name,String email, int customerTypeId, Pageable pageable);
    Page<Customer> searchName(String name,String email, Pageable pageable);
    boolean addNewCustomer(Customer customer);
    boolean editCustomer(Customer customer);
    Customer findById(int id);
    List<Customer> findAllCustomer();
}
