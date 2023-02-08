package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    public Blog getById(int id) {
        return iBlogRepository.getReferenceById(id);
    }

    public void deleteById(int id) {
        iBlogRepository.deleteById(id);
    }

    public boolean update(Blog blog) {
        try {
            if (!iBlogRepository.existsById(blog.getId())) {
                throw new SQLException("Title is already exists");
            } else {
                iBlogRepository.save(blog);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public void add(Blog blog){
        iBlogRepository.save(blog);
    }

    public Boolean existsByTitle(String title){
        return iBlogRepository.existsByTitle(title);
    }

}
