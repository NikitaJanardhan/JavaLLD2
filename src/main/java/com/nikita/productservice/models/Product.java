package com.nikita.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel{

     private String title;
     private String description;
     private Category category;
     private double price;
     private String imageUrl;


}
