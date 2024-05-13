package com.nikita.productservice.services;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service


public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDto[].class

        );
        List<Product> ans = new ArrayList<>();

        for(ProductDto productDto: l.getBody()){
            Product product = new Product();

            product.setId(productDto.getId());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);

            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setImageUrl(productDto.getImage());
            product.setTitle(productDto.getTitle());
            ans.add(product);
        }
        return ans;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                ProductDto.class, productId);

        ProductDto productDto = response.getBody();
        Product product = new Product();

        product.setId(productDto.getId());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        product.setTitle(productDto.getTitle());
        return product;


    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products", product,
                ProductDto.class);
        ProductDto productDto = response.getBody();

        Product product1 = new Product();

        product1.setId(productDto.getId());

        Category category = new Category();
        category.setName(productDto.getCategory());
        product1.setCategory(category);

        product1.setDescription(productDto.getDescription());
        product1.setPrice(productDto.getPrice());
        product1.setImageUrl(productDto.getImage());
        product1.setTitle(productDto.getTitle());
        return product1;

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
