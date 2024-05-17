package com.nikita.productservice.repositiories;

import com.nikita.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CatagoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);


}
