package com.example.blog.blogs.apis.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found!!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
