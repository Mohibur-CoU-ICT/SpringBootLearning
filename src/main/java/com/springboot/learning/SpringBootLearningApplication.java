package com.springboot.learning;

import com.springboot.learning.entity.User;
import com.springboot.learning.repositoy.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        List<User> usersByName = userRepository.findByName("Mohibur");
        System.out.println("usersByName: " + usersByName);

        List<User> usersByCity = userRepository.findByCity("Comilla");
        System.out.println("usersByCity: " + usersByCity);

        List<User> usersByNameAndCity = userRepository.findByNameAndCity("Mohibur", "comilla");
        System.out.println("usersByNameAndCity: " + usersByNameAndCity);
    }

}
