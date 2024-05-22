package com.nikita.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity


public class Category extends BaseModel{
    private String name;
    private String description;
    //private Dummy dummy;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category",cascade = {CascadeType.REMOVE})
    @Fetch(FetchMode.SELECT)
    //@BatchSize(size = 1)


    private Set<Product> products;


}
