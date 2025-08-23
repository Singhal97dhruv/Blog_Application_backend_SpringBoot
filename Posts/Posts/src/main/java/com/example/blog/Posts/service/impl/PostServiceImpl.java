package com.example.blog.Posts.service.impl;

import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.repositories.PostRepository;
import com.example.blog.Posts.service.PostService;
import com.example.blog.Posts.utilities.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId) {

        Post post=modelMapper.map(postDTO,Post.class);
        post.setUserId(userId);
        post.setCategoryId(categoryId);
        post.setAddDate(new Date());
        post.setImageName("default.png");
        Post post1= postRepository.save(post);
        PostDTO postDTO1=modelMapper.map(post1,PostDTO.class);
        return postDTO1;
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post with given id not found on server: "+postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageName(postDTO.getImageName());
        Post post1=postRepository.save(post);
        return modelMapper.map(post1,PostDTO.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post with given id not found on server: "+postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {

        List<Post>posts=postRepository.findAll();
        List<PostDTO> postDTOS=posts.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();

        return postDTOS;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post with given id not found on server: "+postId));
        return modelMapper.map(post,PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPostsByCategory(Integer categoryId) {
        List<Post>postsByCategoryId=postRepository.findByCategoryId(categoryId);
        List<PostDTO>postDTOList=postsByCategoryId.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();
        return postDTOList;
    }

    @Override
    public List<PostDTO> getAllPostsByUser(Integer userId) {

        List<Post>postByUserId=postRepository.findByUserId(userId);
        List<PostDTO>postDTOList=postByUserId.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();

        return postDTOList;
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        return List.of();
    }
}
