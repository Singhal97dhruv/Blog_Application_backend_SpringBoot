package com.example.blog.categories.services.impl;

import com.example.blog.categories.entities.Category;
import com.example.blog.categories.exception.ResourceNotFoundException;
import com.example.blog.categories.repository.CategoryRepository;
import com.example.blog.categories.services.CategoryService;
import com.example.blog.categories.utilities.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);

    }

    @Override
    public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with given id not found on server: " + categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());

        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with given id not found on server: " + categoryId));

        categoryRepository.delete(category);

    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        categoryDTOList = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();

        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with given id not found on server: " + categoryId));
        return modelMapper.map(category, CategoryDTO.class);
    }
}
