package com.example.blog.categories.services;

import com.example.blog.categories.utilities.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO);

    void deleteCategory(Integer categoryId);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategory(Integer categoryId);


}
