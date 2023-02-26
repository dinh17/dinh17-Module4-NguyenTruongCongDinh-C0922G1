package com.example.onthi2.service;

import com.example.onthi2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> searchName(String name,String  describer, Pageable pageable);
    boolean addProduct(Product product);
    boolean editProduct(Product product);
    void remove(int id);
}
