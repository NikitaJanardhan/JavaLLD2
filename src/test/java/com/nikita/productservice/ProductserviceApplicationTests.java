package com.nikita.productservice;


import com.nikita.productservice.inheritanceexample.jointtable.JTMentorrepository;
import com.nikita.productservice.inheritanceexample.jointtable.Mentor;
import com.nikita.productservice.inheritanceexample.jointtable.User;
import com.nikita.productservice.inheritanceexample.jointtable.JTUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductserviceApplicationTests {
    @Autowired
    private JTUserRepository UserRepository;
    @Autowired
    private JTMentorrepository MentorRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void testDifferentInheritance() {
        User user=new User();
        user.setEmail("nikita@scaler.com");
        user.setPassword("Password");
        UserRepository.save(user);

        Mentor mentor=new Mentor();
        mentor.setEmail("anuscaler.com");
        mentor.setPassword("Noopdse");
        mentor.setNoOfMenties(4);
        mentor.setNoOfSessions(50);
        MentorRepository.save(mentor);

    }


}
