package com.nikita.productservice.services;

import org.springframework.stereotype.Service;

@Service

public class FakeStoreCatagoryServiceImpl implements CategoryService{


    @Override
    public String getAllCategories() {
        return "";
    }

    @Override
    public String getProductInCategory(Long catagoriesId) {
        return "";
    }
}
