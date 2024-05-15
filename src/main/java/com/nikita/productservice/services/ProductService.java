package com.nikita.productservice.services;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();


    Optional<Product>getSingleProduct(Long productId);



    Product addNewProduct(ProductDto product);




    Product updateProduct(Long productId,Product product);


    Product ReplaceProduct(Long productId, Product product);

    boolean deleteProduct(Long productId);

}
