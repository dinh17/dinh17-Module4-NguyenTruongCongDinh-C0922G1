package com.codegym.blog_managerment.service;

import com.codegym.blog_managerment.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
}
