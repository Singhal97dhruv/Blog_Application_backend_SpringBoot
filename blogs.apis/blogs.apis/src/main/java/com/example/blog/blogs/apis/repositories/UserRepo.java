package com.example.blog.blogs.apis.repositories;

import com.example.blog.blogs.apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {



}
