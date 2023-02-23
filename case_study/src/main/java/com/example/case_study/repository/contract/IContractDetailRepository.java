package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findByContract(Contract contract);
}
