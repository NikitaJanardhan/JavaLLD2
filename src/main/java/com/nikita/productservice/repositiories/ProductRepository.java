package com.nikita.productservice.repositiories;

import com.nikita.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);
}
