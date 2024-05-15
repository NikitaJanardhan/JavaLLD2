package com.nikita.productservice.services;

import com.nikita.productservice.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FakeStoreCatagoryServiceImpl implements CategoryService{


    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCatagoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public List<Category> getAllCategories() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity(
//                "http://localhost:8080/category",
//                FakeStoreProductDto[].class);
//        List<Category> ans = new ArrayList<>();
//        for(FakeStoreCatagoryDto catagoryDto: l.getBody()){
//            ans.add(ConvertFakeStoreCatagoryDto(catagoryDto));
//        }
//        return ans;
//    }
        return null;
    }

    @Override
    public String getProductInCategory(Long catagoriesId) {
        return "";
    }
}
