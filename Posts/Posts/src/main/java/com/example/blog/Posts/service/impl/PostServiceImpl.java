package com.example.blog.Posts.service.impl;

import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.repositories.PostRepository;
import com.example.blog.Posts.service.PostService;
import com.example.blog.Posts.utilities.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post createPost(PostDTO postDTO) {
        return null;
    }

    @Override
    public Post updatePost(PostDTO postDTO, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getAllPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getAllPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
