package com.nikita.productservice.inheritanceexample.tableperclass;


import com.nikita.productservice.inheritanceexample.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPCMentorrepository extends JpaRepository<Mentor, Long> {

Mentor save(Mentor mentor);



    Mentor findMentorById(long id);
}
