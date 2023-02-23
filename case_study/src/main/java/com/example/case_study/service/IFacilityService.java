package com.example.case_study.service;

import com.example.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> searchName(String name, Pageable pageable);
    Page<Facility> searchNameAndFacilityType(String name, Integer typeId, Pageable pageable);
    List<Facility> getAllFacility();
    boolean addFacility(Facility facility) ;
    boolean editFacility(Facility facility);
    Facility findById(int id);
}
