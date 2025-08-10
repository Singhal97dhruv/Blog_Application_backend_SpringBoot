package com.example.blog.blogs.apis.exception;

import com.example.blog.blogs.apis.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(message).status(HttpStatus.NOT_FOUND).success(true).build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handlerMethodArgsNotValidException(MethodArgumentNotValidException ex) {

        String errorMsg=ex.getBindingResult().getFieldErrors().stream().map(err->err.getField()+" : "+err.getDefaultMessage()).collect(Collectors.joining(","));

        ApiResponse apiResponse=ApiResponse.builder().message(errorMsg).status(HttpStatus.BAD_REQUEST).success(false).build();

        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);

    }

}
