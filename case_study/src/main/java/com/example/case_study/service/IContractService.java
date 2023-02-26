package com.example.case_study.service;

import com.example.case_study.dto.contract.IContractDto;
import com.example.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> fillAll();
    Contract findById(int id);
    void addContract(Contract contract);
    //    Double getTotal(int id);
    Page<IContractDto> findAllContract(Pageable pageable);
}
