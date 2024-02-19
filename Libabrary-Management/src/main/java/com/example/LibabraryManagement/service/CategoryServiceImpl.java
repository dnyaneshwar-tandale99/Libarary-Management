package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Category;
import com.example.LibabraryManagement.repository.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    public static final Logger LOGGER = LogManager.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        LOGGER.info("Inside Get All Category Method :: CategoryServiceImpl");
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(long id) {
        LOGGER.info("Inside getCategoryById method :: CategoryServiceImpl");
        Category category;
        category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Category found with Id " + id));
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        LOGGER.info("Inside Create Category method to create an category in DB :: CategoryServiceImpl");
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        LOGGER.info("Inside update Category method to Update an Category in DB :: CategoryServiceImpl");
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        LOGGER.info("Inside DeleteCategoryById :: CategoryServiceImpl");
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Category found with Id " + id));
        categoryRepository.deleteById(category.getId());
    }
}
