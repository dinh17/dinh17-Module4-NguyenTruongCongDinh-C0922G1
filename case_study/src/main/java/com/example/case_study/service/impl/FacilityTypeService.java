package com.example.case_study.service.impl;

import com.example.case_study.model.facility.FacilityType;
import com.example.case_study.repository.IFacilityTypeRepository;
import com.example.case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> getAllType() {
        return facilityTypeRepository.findAll();
    }
}
