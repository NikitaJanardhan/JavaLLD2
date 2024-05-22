package com.nikita.productservice;

import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.repositiories.CategoryRepository;
import com.nikita.productservice.repositiories.ProductDBDTo;
import com.nikita.productservice.repositiories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest

public class ProductTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void SavingProductAndCategory() {
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
    void FetchTypeTest() {
        Product product = productRepository.findProductById(1L);
        System.out.println("Fetched Product");
        Category category = product.getCategory();
        String name = category.getName();
    }

    @Test
    void DeleteProduct() {
        productRepository.deleteById(1L);

    }

    @Test
    @Transactional
    //@Rollback(value = false)
    @Commit()
    void savedProductForCategory() {
        Category category = categoryRepository.findById(2L).get();

        Product product = new Product();
        product.setPrice(444);
        product.setImageUrl("By");
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);

        product = new Product();
        product.setPrice(555);
        product.setImageUrl("By");
        product.setCategory(category);
        productRepository.save(product);

        Category category1 = new Category();
        category.setName("No");
        categoryRepository.save(category1);
    }

    @Test
    @Transactional
    void getProductForCategory() throws InterruptedException {
        // Category category = categoryRepository.findById(2L).get();
        List<Category> categories = categoryRepository.findAllByIdIn(List.of(2L, 52L));

        Thread.sleep(100L);
        System.out.println("Doing something");
        Thread.sleep(100L);

        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                System.out.println(product.getPrice());
            }
        }
    }

    @Test
    @Transactional
    void getProductForCategory1() throws InterruptedException {
        // Category category = categoryRepository.findById(2L).get();
        Category category = categoryRepository.findById(2L).get();


        Thread.sleep(100L);
        System.out.println("Doing something");
        Thread.sleep(100L);

        //for(Category category:categories){
        for (Product product : category.getProducts()) {
            System.out.println(product.getPrice());
        }
    }
    @Test
    public void demonstrateCustomQueries() {
        List<ProductDBDTo> productDBDTos = productRepository.laaoProductsWithId(303L);
        List<Product> products = productRepository.getByIdAndTitle(1L, "hi");
    }
}