package com.nikita.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
//@AllArgsConstructor
//@NoArgsConstructor

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
