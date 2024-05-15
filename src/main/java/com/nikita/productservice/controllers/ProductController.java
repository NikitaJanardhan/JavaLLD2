package com.nikita.productservice.controllers;

import com.nikita.productservice.dto.ErrorResponceDto;
import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.exceptions.NotFoundException;
import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import com.nikita.productservice.repositiories.ProductRepository;
import com.nikita.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ProductController {
    private final ProductService productService;
    private ProductRepository productRepository;
    public ProductController(ProductService productService,ProductRepository productRepository) {
        this.productRepository=productRepository;
        this.productService = productService;
    }
    @GetMapping("/products")

    public List<Product> getAllProduct(){
        return productService.getAllProduct();

    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId)
            throws NotFoundException {
        //GetSingleProductDtos responseDto = new GetSingleProductDtos();
        //responseDto.setProduct(
        MultiValueMap<String,String>headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth_token","AVnu8ioopegytdq");

        Optional<Product> product = productService.getSingleProduct(productId);
        if (product.isEmpty()) {
            throw new NotFoundException("Product not found:"+productId);
        }

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
        //Product newProduct=productService.addNewProduct(product);

        Product newProduct=new Product();
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImage());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        newProduct=productRepository.save(newProduct);



        ResponseEntity<Product> response=new ResponseEntity<>(
                newProduct,HttpStatus.OK

        );

        return response;
    }
    @PatchMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,
                                 @RequestBody ProductDto productDto){
    Product product=new Product();
    product.setId(productDto.getId());
    product.setTitle(productDto.getTitle());
    product.setPrice(productDto.getPrice());
    product.setDescription(productDto.getDescription());
    product.setCategory(new Category());
    product.getCategory().setName(productDto.getCategory());


        return productService.updateProduct(productId,product);
    }
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId")Long productId){
        return "Deleting Product with id: " + productId;
    }
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponceDto> Nikita(Exception exception){
//        ErrorResponceDto errorResponceDto=new ErrorResponceDto();
//        errorResponceDto.setErrorMessage(exception.getMessage());
//        return new ResponseEntity<>(errorResponceDto, HttpStatus.NOT_FOUND);


   // }

}
