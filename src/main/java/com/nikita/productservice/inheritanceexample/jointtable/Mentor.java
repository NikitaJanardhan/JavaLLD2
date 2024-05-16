package com.nikita.productservice.inheritanceexample.jointtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "User_id")

public class Mentor extends User {
    private int noOfSessions;
    private int noOfMenties;
}
