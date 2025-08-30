package com.example.blog.Posts.service.impl;

import com.example.blog.Posts.entities.Post;
import com.example.blog.Posts.payload.PostResponse;
import com.example.blog.Posts.repositories.PostRepository;
import com.example.blog.Posts.service.PostService;
import com.example.blog.Posts.utilities.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PostResponse getAllPosts(Integer pageSize, Integer pageNumber, String sortBy, String sortDir) {

        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);

        Page<Post> page=postRepository.findAll(pageable);
        List<Post>posts=page.getContent();
        List<PostDTO> postDTOS=posts.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();

        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postDTOS);
        postResponse.setPageNumber(pageNumber);
        postResponse.setPageSize(pageSize);
        postResponse.setTotalPosts(page.getTotalElements());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setLastPage(page.isLast());

        return postResponse;
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

        List<Post> posts=postRepository.findByTitleContaining(keyword);

        List<PostDTO>postDTOList=posts.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();

        return postDTOList;
    }
}
