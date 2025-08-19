package com.example.blog.Posts.repositories;

import com.example.blog.Posts.entities.Category;
import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategories(Category category);
}
