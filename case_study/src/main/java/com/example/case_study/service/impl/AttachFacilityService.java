package com.example.case_study.service.impl;


import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.repository.contract.IAttachFacilityRepository;
import com.example.case_study.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    public List<AttachFacility> findAttachFacilityByContractId(int id) {
        return attachFacilityRepository.findAttachFacilityByContractId(id);
    }

    public int getQuantity(int id, int idAf) {
        return attachFacilityRepository.getQuantity(id, idAf);
    }

    public AttachFacility findById(int id) {
        return attachFacilityRepository.getReferenceById(id);
    }

}
