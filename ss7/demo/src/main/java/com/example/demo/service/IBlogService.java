package com.example.demo.service;


import com.example.demo.model.Blog;

import java.util.List;


public interface IBlogService {
    List<Blog> findAll();

    Blog getById(int id);

    void deleteById(int id);

    boolean update(Blog blog);
    void add(Blog blog);

    Boolean existsByTitle(String title);
}
