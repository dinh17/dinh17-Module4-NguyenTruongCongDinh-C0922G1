package com.example.case_study.service.impl;

import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.repository.contract.IContractDetailRepository;
import com.example.case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    public void addContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
