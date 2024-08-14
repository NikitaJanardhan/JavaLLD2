package com.nikita.productservice.services;

import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service(value = "SelfProductService")

public class SelfProductService implements ProductService {
    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        return Optional.empty();
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product ReplaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
