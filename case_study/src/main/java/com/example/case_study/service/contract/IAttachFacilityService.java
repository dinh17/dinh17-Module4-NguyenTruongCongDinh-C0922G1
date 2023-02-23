package com.example.case_study.service.contract;

import com.example.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
AttachFacility getAttachFacilityInfo(int id);
List<AttachFacility> getAllAttachFacility();
String getNameById(Integer id);
}
