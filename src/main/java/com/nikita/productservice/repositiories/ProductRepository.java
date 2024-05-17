package com.nikita.productservice.repositiories;

import com.nikita.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);
    Product findProductById(Long id);
}
