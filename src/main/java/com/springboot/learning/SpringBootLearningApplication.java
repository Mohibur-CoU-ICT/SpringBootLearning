package com.springboot.learning;

import com.springboot.learning.entity.User;
import com.springboot.learning.repositoy.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User();
        user.setName("Mohibur");
        user.setCity("Comilla");
        user.setStatus("I am a Java Developer");

        user = userRepository.save(user);

        System.out.println(user);
    }

}
