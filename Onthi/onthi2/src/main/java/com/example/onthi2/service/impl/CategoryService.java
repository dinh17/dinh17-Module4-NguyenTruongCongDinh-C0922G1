package com.example.onthi2.service.impl;

import com.example.onthi2.model.Category;
import com.example.onthi2.repository.ICategoryRepository;
import com.example.onthi2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
