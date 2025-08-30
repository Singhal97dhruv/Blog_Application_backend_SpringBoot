package com.example.blog.Posts.controller;

import com.example.blog.Posts.payload.ApiResponse;
import com.example.blog.Posts.payload.PostResponse;
import com.example.blog.Posts.repositories.PostRepository;
import com.example.blog.Posts.service.PostService;
import com.example.blog.Posts.utilities.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId, @PathVariable Integer categoryId) {

        PostDTO postDTO1 = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<>(postDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<PostResponse> getPosts(
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "sortBy", defaultValue = "postId", required=false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required=false) String sortDir
    ) {
        PostResponse posts = postService.getAllPosts(pageSize, pageNumber, sortBy, sortDir);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId) {
        PostDTO postDTO = postService.getPostById(postId);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postId) {
        PostDTO postDTO1 = postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(postDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post with id " + postId + " has been deleted successfully!", HttpStatus.OK, true), HttpStatus.OK);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDTO> postDTOList = postService.getAllPostsByCategory(categoryId);
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDTO> postDTOList = postService.getAllPostsByUser(userId);
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/search/{postTitle}")
    public ResponseEntity<List<PostDTO>> getPostsByTitle(@PathVariable String postTitle) {
        List<PostDTO> postDTOList = postService.searchPosts(postTitle);
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }
}
