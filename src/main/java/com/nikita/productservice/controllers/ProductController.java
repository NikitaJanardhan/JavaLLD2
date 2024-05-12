package com.nikita.productservice.controllers;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")

    public String getAllProduct(){
        return "Getting All Products";
    }
    @GetMapping("/products/{productId}")

    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Returning Single Product with id: " + productId;
    }
    @PostMapping("/products")
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding New Product with" + productDto;
    }
    @PutMapping("/products/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating Product with id: "+productId;
    }
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId")Long productId){
        return "Deleting Product with id: " + productId;
    }

}
