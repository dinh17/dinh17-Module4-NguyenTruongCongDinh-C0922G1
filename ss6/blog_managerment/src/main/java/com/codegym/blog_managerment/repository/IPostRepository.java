package com.codegym.blog_managerment.repository;

import com.codegym.blog_managerment.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Integer> {
}
