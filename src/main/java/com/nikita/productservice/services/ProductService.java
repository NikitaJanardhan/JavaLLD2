package com.nikita.productservice.services;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();


    Product getSingleProduct(Long productId);


    Product addNewProduct(ProductDto product);




    Product updateProduct(Long productId,Product product);


    boolean deleteProduct(Long productId);

}
