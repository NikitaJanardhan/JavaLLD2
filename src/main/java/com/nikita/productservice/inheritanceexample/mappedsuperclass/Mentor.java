package com.nikita.productservice.inheritanceexample.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mp_mentor")


public class Mentor extends User {
    private int noOfSessions;
    private int noOfMenties;
}
