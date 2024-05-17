package com.nikita.productservice;

import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.repositiories.CatagoryRepository;
import com.nikita.productservice.repositiories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest

class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatagoryRepository catagoryRepository;
    @Test
    void savingProductAndCategory(){

        Category category = new Category();
        category.setName("phones");
        Category SavedCategory = catagoryRepository.save(category);

        Product product=new Product();
        product.setPrice(35);
        product.setImageUrl("Hello");
        product.setCategory(category);
        productRepository.save(product);
    }
    @Test
    @Transactional
    void FetchTypeTest(){
        Product product=productRepository.findProductById(1L);
        System.out.println("Fetched product");

       Category category = product.getCategory();
      // String categoryName = category.getName();

    }


}