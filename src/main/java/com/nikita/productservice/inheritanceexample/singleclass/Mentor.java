package com.nikita.productservice.inheritanceexample.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue("2")

public class Mentor extends User {
    private int noOfSessions;
    private int noOfMenties;
}
