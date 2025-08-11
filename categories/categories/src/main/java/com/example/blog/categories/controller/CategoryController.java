package com.example.blog.categories.controller;

import com.example.blog.categories.payload.ApiResponse;
import com.example.blog.categories.services.CategoryService;
import com.example.blog.categories.utilities.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryDTO1 = categoryService.updateCategory(categoryId, categoryDTO);

        return new ResponseEntity<>(categoryDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {

        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", HttpStatus.NO_CONTENT, true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId) {
        CategoryDTO categoryDTO = categoryService.getCategory(categoryId);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

}