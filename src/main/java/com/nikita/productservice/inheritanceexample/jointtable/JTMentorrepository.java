package com.nikita.productservice.inheritanceexample.jointtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JTMentorrepository extends JpaRepository<Mentor, Long> {
    Mentor save(Mentor mentor);

    Mentor findMentorById(long id);
}
