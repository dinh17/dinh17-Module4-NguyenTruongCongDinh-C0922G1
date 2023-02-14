package com.example.blog_version2.service.impl;

import com.example.blog_version2.model.Category;
import com.example.blog_version2.repository.ICategoryRepository;
import com.example.blog_version2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService  implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository ;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
      iCategoryRepository.deleteById(id);
    }
}
