package com.nikita.productservice.controllers;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/products")

    public List<Product> getAllProduct(){
        return productService.getAllProduct();

    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
        //GetSingleProductDtos responseDto = new GetSingleProductDtos();
        //responseDto.setProduct(
        MultiValueMap<String,String>headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth_token","AVnu8ioopegytdq");

        ResponseEntity<Product> response=new ResponseEntity(productService
                .getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND
        );
              //return   productService.getSingleProduct(productId);
        return response;

        //);
        //return responseDto;
    }
    @PostMapping("/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product newProduct=productService.addNewProduct(product);
        ResponseEntity<Product> response=new ResponseEntity<>(
                newProduct,HttpStatus.OK

        );

        return response;
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
