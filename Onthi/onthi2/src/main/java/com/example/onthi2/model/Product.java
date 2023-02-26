package com.example.onthi2.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  int id ;
    @Column(columnDefinition="varchar(255)")
    private String name;
    private int quantity ;
    @Column(columnDefinition="varchar(255)")
    private String describer;
    private Double price ;
    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName ="id" )
    private Category category;

    public Product() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
