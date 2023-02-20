package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>  {

    boolean existsByIdCardAndPhoneNumberAndEmail(String idCard, String phoneNumber, String email);

}
