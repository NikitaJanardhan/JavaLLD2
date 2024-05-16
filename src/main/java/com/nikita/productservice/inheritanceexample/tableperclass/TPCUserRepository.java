package com.nikita.productservice.inheritanceexample.tableperclass;


import com.nikita.productservice.inheritanceexample.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TPCUserRepository extends JpaRepository<User, Long> {

User save(User user);


    User findUserById(Long id);
}
