package com.nikita.productservice.client.fakestoreapi;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.exceptions.NotFoundException;
import com.nikita.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component


public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakeStoreProductDto> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        return Arrays.asList(l.getBody());
    }
    Optional<FakeStoreProductDto> getSingleProduct(Long productId)throws NotFoundException{
        return null;
    };
    FakeStoreProductDto addNewProduct(ProductDto product){
        return null;
    };
    FakeStoreProductDto updateProduct(Long productId,Product product){
        return null;
    };


    FakeStoreProductDto ReplaceProduct(Long productId, Product product){
        return null;
    };

    FakeStoreProductDto deleteProduct(Long productId){
        return null;
    };

}
