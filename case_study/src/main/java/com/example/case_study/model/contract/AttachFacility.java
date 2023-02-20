package com.example.case_study.model.contract;


import javax.persistence.*;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String name ;
    private Double cost ;
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String unit;
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String status;

    public AttachFacility() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
