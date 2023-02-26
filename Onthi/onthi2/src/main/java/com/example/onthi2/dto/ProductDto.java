package com.example.onthi2.dto;

import com.example.onthi2.model.Category;

import javax.validation.constraints.NotBlank;


public class ProductDto {
    private  int id ;
    @NotBlank(message = "tên không được để trống")
    private String name;
    private int quantity ;
    @NotBlank(message = "tên không được để trống")
    private String describer;
    private Double price ;
    private Category category;

    public ProductDto() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
