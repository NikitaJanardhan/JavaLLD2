package com.nikita.productservice.services;

import com.nikita.productservice.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
    String getAllProduct();


    String getSingleProduct(Long productId);


    String addNewProduct(ProductDto productDto);


    String updateProduct(Long productId);


    String deleteProduct(Long productId);
}
