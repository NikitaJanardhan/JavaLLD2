package com.nikita.productservice.services;

import com.nikita.productservice.models.Category;

import java.util.List;

public class SelfCategoryService implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public String getProductInCategory(Long catagoriesId) {
        return "";
    }
}
