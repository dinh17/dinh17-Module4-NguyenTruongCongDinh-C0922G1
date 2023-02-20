package com.example.case_study.service.customer;

import com.example.case_study.dto.customer.CustomerDto;
import com.example.case_study.model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAll();
    void add(Customer customer);
    Map<String,String> getError(CustomerDto customerDto);
    boolean existsByIdCardAndPhoneNumberAndEmail(String idCard,String phoneNumber,String email);
}
