package com.example.blog.Posts.utilities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class PostDTO {
    private String title;

    private String content;

    private String imageName;

    private Date addDate;

//    private int categoryId;

//    private int userId;
}
