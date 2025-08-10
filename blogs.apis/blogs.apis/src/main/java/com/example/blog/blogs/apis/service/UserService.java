package com.example.blog.blogs.apis.service;

import com.example.blog.blogs.apis.entities.User;
import com.example.blog.blogs.apis.utilities.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);

}
