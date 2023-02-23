package com.example.case_study.service.contract;


import com.example.case_study.model.contract.AttachFacilityDto;
import com.example.case_study.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<AttachFacilityDto> getAllAttachFacility(int contractId);

    boolean addContractDetail(ContractDetail contractDetail);
}
