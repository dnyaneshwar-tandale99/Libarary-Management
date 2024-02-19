package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Book;
import com.example.LibabraryManagement.Entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category getCategoryById(long id);
    public void saveCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(long id);
}
