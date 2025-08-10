package com.example.blog.blogs.apis.controller;

import com.example.blog.blogs.apis.entities.User;
import com.example.blog.blogs.apis.payload.ApiResponse;
import com.example.blog.blogs.apis.service.UserService;
import com.example.blog.blogs.apis.utilities.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO userDTO1= userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO1);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userId)
    {
        UserDTO userDTO1=userService.updateUser(userDTO,userId);
        return ResponseEntity.ok(userDTO1);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",HttpStatus.NO_CONTENT,true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>>getAllUsers(){
        List<UserDTO> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO>getUser(@PathVariable Integer userId){
        UserDTO userDTO=userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

}
