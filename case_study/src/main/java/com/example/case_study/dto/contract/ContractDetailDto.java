package com.example.case_study.dto.contract;

import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.model.contract.Contract;

public class ContractDetailDto {
    private int id;
    private Contract contract;
    private AttachFacility attachFacility;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
