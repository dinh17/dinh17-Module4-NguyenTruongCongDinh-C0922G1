package com.example.case_study.service.impl;

import com.example.case_study.dto.contract.IContractDto;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.repository.contract.IContractRepository;
import com.example.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    public List<Contract> fillAll() {
        return iContractRepository.findAll();
    }

    public Contract findById(int id) {
        return iContractRepository.getReferenceById(id);
    }

    public void addContract(Contract contract) {
        iContractRepository.save(contract);
    }


//    public Double getTotal(int id) {
//        return iContractRepository.getTotal(id);
//    }

    public Page<IContractDto> findAllContract(Pageable pageable) {
        return iContractRepository.findAllContract(pageable);
    }
}
