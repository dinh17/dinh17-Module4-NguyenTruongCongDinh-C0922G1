package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
