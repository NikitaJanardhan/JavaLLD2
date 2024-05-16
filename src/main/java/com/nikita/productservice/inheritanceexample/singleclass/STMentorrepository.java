package com.nikita.productservice.inheritanceexample.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository



public interface STMentorrepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);





    Mentor findMentorById(long id);
}
