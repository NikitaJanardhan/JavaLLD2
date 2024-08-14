package com.nikita.productservice.client.authanticationclient.dto;

import com.nikita.productservice.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Role extends BaseModel {
    private String name;
}
