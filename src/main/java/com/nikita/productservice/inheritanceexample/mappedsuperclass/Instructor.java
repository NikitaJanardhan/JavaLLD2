package com.nikita.productservice.inheritanceexample.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mp_instructor")


public class Instructor extends User {
    private boolean ishandsome;
}
