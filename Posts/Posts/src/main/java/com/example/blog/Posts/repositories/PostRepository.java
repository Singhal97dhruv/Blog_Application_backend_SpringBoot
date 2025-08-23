package com.example.blog.Posts.repositories;

import com.example.blog.Posts.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUserId(Integer userId);
    List<Post> findByCategoryId(Integer categoryId);
}
