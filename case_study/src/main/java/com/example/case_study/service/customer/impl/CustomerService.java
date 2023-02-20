package com.example.case_study.service.customer.impl;

import com.example.case_study.dto.customer.CustomerDto;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.repository.customer.ICustomerRepository;
import com.example.case_study.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        getError(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public Map<String, String> getError(CustomerDto customerDto) {
        Map<String,String> errorMap = new HashMap<>();

        for (Customer c: findAll()) {
            if(customerDto.getId()!=c.getId()){
                if(c.getIdCard().equals(customerDto.getIdCard())){
                    errorMap.put("errorIdCard","Trùng id card");
//                throw new Exception("E_CONFLICT_ID");
                }
                if(c.getPhoneNumber().equals(customerDto.getPhoneNumber())){
                    errorMap.put("errorPhoneNumber","Trùng số phone");
                }
                if(c.getEmail().equals(customerDto.getEmail())){
                    errorMap.put("errorEmail","Trùng email");
                }
            }
        }
        return errorMap;
    }

    @Override
    public boolean existsByIdCardAndPhoneNumberAndEmail(String idCard, String phoneNumber, String email) {
        return customerRepository.existsByIdCardAndPhoneNumberAndEmail(idCard,phoneNumber,email);
    }
}
