package com.example.onthi2.service.impl;

import com.example.onthi2.model.Product;
import com.example.onthi2.repository.IProductRepository;
import com.example.onthi2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> searchName(String name, String describer, Pageable pageable) {
        return productRepository.searchName(name,describer,pageable);
    }

    @Override
    public boolean addProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean editProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }
}
