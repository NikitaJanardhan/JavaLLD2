package com.nikita.productservice.inheritanceexample.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity(name = "st_instructor")
@DiscriminatorValue("3")

public class Instructor extends User {
    private boolean ishandsome;
}
