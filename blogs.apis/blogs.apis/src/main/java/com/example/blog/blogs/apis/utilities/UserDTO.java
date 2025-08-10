package com.example.blog.blogs.apis.utilities;

import com.example.blog.blogs.apis.repositories.UserRepo;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;
    @NotEmpty
    @Size(min = 2, message = "Username must be atleast 2 letters long")
    private String name;
    @Email(message = "Email address is not valid!!")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$",message = "Password should have atleast one uppercase and lowercase letter and length should be greater than or equal to 8 letters")
    private String password;
    @NotEmpty
    private String about;

}
