package com.example.case_study.controller.RestController;

import com.example.case_study.dto.contract.AttachFacilityDto;
import com.example.case_study.dto.contract.ContractDto;
import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/contracts")
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getAttachFacilityById(@PathVariable("id") int id) {
        List<AttachFacility> attachFacilities = attachFacilityService.findAttachFacilityByContractId(id);
        List<AttachFacilityDto> attachFacilityDtos = new ArrayList<>();
        for (AttachFacility attachFacility : attachFacilities) {
            AttachFacilityDto attachFacilityDto = new AttachFacilityDto();
            BeanUtils.copyProperties(attachFacility, attachFacilityDto);
            attachFacilityDto.setQuantity(attachFacilityService.getQuantity(id, attachFacility.getId()));
            attachFacilityDtos.add(attachFacilityDto);
        }
        return new ResponseEntity<>(attachFacilityDtos, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = {"application/json"})
    public ResponseEntity<Map<String, String>> createContract(@Validated @RequestBody ContractDto contractDto, BindingResult bindingResult) {
        Map<String, String> errors = new LinkedHashMap<>();
        new ContractDto().validate(contractDto, bindingResult);
        bindingResult.getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        if (errors.isEmpty()) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.addContract(contract);
        }
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }
}
