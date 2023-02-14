package com.example.case_study.model.employee;


import com.example.case_study.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id ;
    @Column(columnDefinition ="varchar(45)")
    private  String name;
    @Column(columnDefinition ="date")
    private String dateOfBirth ;
    @Column(columnDefinition =" varchar(45)",unique = true)
    private String id_card ;
    private String salary ;
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String phone_number ;
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String email ;
    @Column(columnDefinition = "varchar(45)")
    private String address ;
    @ManyToOne
    @JoinColumn(name = "position_id",nullable = false,referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id",nullable = false,referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false,referencedColumnName = "id")
    private Division division ;

    private String user;
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;


    public Employee(String name, String dateOfBirth, String id_card, String salary, String phone_number, String email, String address, Position position, EducationDegree educationDegree, String user, Set<Contract> contracts) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id_card = id_card;
        this.salary = salary;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.user = user;
        this.contracts = contracts;
    }

    public Employee() {

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
