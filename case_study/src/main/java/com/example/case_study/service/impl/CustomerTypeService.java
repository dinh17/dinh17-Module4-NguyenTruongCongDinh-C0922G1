package com.example.case_study.service.impl;


import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.repository.ICustomerTypeRepository;
import com.example.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
