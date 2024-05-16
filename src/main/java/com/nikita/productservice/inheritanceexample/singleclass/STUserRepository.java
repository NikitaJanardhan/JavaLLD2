package com.nikita.productservice.inheritanceexample.singleclass;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STUserRepository extends JpaRepository<User, Long> {

User save(User user);


    User findUserById(Long id);
}
