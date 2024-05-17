package com.nikita.productservice.inheritanceexample.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")

public class Mentor extends User {
    private int noOfSessions;
    private int noOfMenties;
}
