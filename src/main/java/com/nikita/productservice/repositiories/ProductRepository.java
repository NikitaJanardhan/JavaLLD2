package com.nikita.productservice.repositiories;

import com.nikita.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);
    Product findProductById(Long id);
    Product findProductByIds(Long id);
    Product findProductByIdEquals(Long id);
    Product findByPriceBetween(Double greaterThanEqualsPrice, Double lessThanEqualsPrice);
    Product findByPriceBetweenAndtitleLessThanEqual(Double greaterThanEqualsPrice,
                                                    Double lessThanEqualsPrice,String TiteLessThan);
    Product findByPriceLessThanEqual(Double price);

    List<Product>findByImageUrlIsNull();
    List<Product>findBytitleStartsWith(String title);
    List<Product>findByTitleLike(String titleLike);

}
