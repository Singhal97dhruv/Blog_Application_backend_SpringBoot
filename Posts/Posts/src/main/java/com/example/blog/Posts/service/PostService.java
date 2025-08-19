package com.example.blog.Posts.service;

import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.utilities.PostDTO;

import java.util.List;

public interface PostService {

    //Create Post
    Post createPost(PostDTO postDTO);

    //Update Post
    Post updatePost(PostDTO postDTO, Integer postId);

    //Delete POST
    void deletePost(Integer postId);

    //GET all posts
    List<Post> getAllPosts();

    //Single Post
    Post getPostById(Integer postId);

    //Get all posts by category
    List<Post> getAllPostsByCategory(Integer categoryId);

    //Get all posts by user
    List<Post> getAllPostsByUser(Integer userId);

    //Search posts
    List<Post> searchPosts(String keyword);

}
