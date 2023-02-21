package com.example.case_study.service.impl;

import com.example.case_study.model.facility.RentType;
import com.example.case_study.repository.IRentTypeRepository;
import com.example.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getAllRentType() {
        return rentTypeRepository.findAll();
    }
}
