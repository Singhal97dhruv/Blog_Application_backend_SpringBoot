package com.example.blog.Posts.service;

import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.payload.PostResponse;
import com.example.blog.Posts.utilities.PostDTO;

import java.util.List;

public interface PostService {

    //Create Post
    PostDTO createPost(PostDTO postDTO,Integer userId, Integer categoryId);

    //Update Post
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    //Delete POST
    void deletePost(Integer postId);

    //GET all posts
    PostResponse getAllPosts(Integer pageSize, Integer pageNumber, String sortBy, String sortDir);

    //Single Post
    PostDTO getPostById(Integer postId);

    //Get all posts by category
    List<PostDTO> getAllPostsByCategory(Integer categoryId);

    //Get all posts by user
    List<PostDTO> getAllPostsByUser(Integer userId);

    //Search posts
    List<PostDTO> searchPosts(String keyword);

}
