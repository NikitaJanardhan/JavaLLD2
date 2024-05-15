package com.nikita.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass


public class BaseModel {
    @Id
    @GeneratedValue()

    private  Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;

}
