package com.example.blog.blogs.apis.service.UserServiceImpl;

import com.example.blog.blogs.apis.entities.User;
import com.example.blog.blogs.apis.exception.ResourceNotFoundException;
import com.example.blog.blogs.apis.repositories.UserRepo;
import com.example.blog.blogs.apis.service.UserService;
import com.example.blog.blogs.apis.utilities.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user=modelMapper.map(userDTO,User.class);
        User savedUser= userRepo.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO user, Integer userId) {

        User orgUser=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server: " + userId));

        orgUser.setName(user.getName());
        orgUser.setAbout(user.getAbout());
        orgUser.setEmail(user.getEmail());
        orgUser.setPassword(user.getPassword());

        User updatedUser=userRepo.save(orgUser);

        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Integer userId) {

        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server: " + userId));

        UserDTO userDTO1=modelMapper.map(user, UserDTO.class);
        return userDTO1;
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users=userRepo.findAll();
        List<UserDTO>userDTOS=new ArrayList<>();
        userDTOS=users.stream().map(user -> modelMapper.map(user,UserDTO.class)).toList();

        return userDTOS;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server: " + userId));

        userRepo.delete(user);
    }
}
