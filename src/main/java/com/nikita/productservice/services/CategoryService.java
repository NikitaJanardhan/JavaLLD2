package com.nikita.productservice.services;

import com.nikita.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();


    String getProductInCategory(Long catagoriesId);
}
