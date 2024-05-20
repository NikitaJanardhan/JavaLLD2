package com.nikita.productservice;

import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.repositiories.CategoryRepository;
import com.nikita.productservice.repositiories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest

public class ProductTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

@Test
    void SavingProductAndCategory(){
//        Category category = new Category();
//        category.setName("Phones");
//        Category categorySaved=categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setPrice(100);
//        product.setImageUrl("By");
//        product.setCategory(category);
//        productRepository.save(product);

    Category category = new Category();
    category.setName("electronic");
    //Category categorySaved=categoryRepository.save(category);

    Product product = new Product();
    product.setPrice(100);
    product.setImageUrl("By");
    product.setCategory(category);
    productRepository.save(product);
    }
    @Test
    @Transactional
    void FetchTypeTest(){
    Product product =productRepository.findProductById(1L);
    System.out.println("Fetched Product");
    Category category=product.getCategory();
    String name=category.getName();
    }

    @Test
    void DeleteProduct(){
        productRepository.deleteById(1L);

    }
}
