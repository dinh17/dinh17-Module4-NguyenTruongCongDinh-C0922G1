package com.example.onthi3.model;
import javax.validation.constraints.NotBlank;
public class EmployeeDto {
    private int id;
    @NotBlank(message = "tên không được để trống")
    private String name;
    private int gender;
    private Position position;
    private Double salary;
    @NotBlank(message = "số dt không thể để trống")
    private String phoneNumber;
    @NotBlank(message = "email không thể để trống")
    private String email;


    public EmployeeDto() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
