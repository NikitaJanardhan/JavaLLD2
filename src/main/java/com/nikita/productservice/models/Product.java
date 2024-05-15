package com.nikita.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product extends BaseModel{

     private String title;
     private String description;
     //p:c
     //1->1
     //m<-1
     @ManyToOne
     private Category category;
     private double price;
     private String imageUrl;


}
