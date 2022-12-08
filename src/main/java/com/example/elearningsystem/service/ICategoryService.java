package com.example.elearningsystem.service;

import com.example.elearningsystem.model.Category;
import com.example.elearningsystem.model.User;

public interface ICategoryService {
    public Category insertCategory(Category newCategory);
    public Category updateCategory(Long id, Category newCategory);
    public User registerCategory(String username, Long categoryId);

    public Category findCategoryById(Long categoryid);
}
