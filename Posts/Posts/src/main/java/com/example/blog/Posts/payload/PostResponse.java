package com.example.blog.Posts.payload;

import com.example.blog.Posts.utilities.PostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PostResponse {

    List<PostDTO> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalPosts;
    private boolean lastPage;


}
