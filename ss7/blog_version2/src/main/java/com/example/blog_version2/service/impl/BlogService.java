package com.example.blog_version2.service.impl;


import com.example.blog_version2.model.Blog;
import com.example.blog_version2.repository.IBlogRepository;
import com.example.blog_version2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
@Autowired
private IBlogRepository iBlogRepository ;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
      iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void update(Blog blog) {
          iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
           iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return iBlogRepository.searchByTitle(title,pageable);
    }
}
