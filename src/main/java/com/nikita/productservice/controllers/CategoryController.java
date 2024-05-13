package com.nikita.productservice.controllers;

import com.nikita.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/catagories")

public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(final CategoryService categoryService) {

        this.categoryService = categoryService;
    }
    @GetMapping()
    public String getAllCategories() {

        return "Getting All Categories";
    }
    @GetMapping("/{catagoriesId}")
    public String getProductInCategory(@PathVariable ("catagoriesId")Long catagoriesId) {
        return "Getting Product In Category with ID: " + catagoriesId;
    }
}
