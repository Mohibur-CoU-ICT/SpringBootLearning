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

        // custom finder
        System.out.println("Custom finder methods:");
        System.out.println("______________________");
        List<User> usersByName = userRepository.findByName("Mohibur");
        System.out.println("usersByName: " + usersByName);

        List<User> usersByCity = userRepository.findByCity("Comilla");
        System.out.println("usersByCity: " + usersByCity);

        List<User> usersByNameAndCity = userRepository.findByNameAndCity("Mohibur", "comilla");
        System.out.println("usersByNameAndCity: " + usersByNameAndCity);

        // jpql
        System.out.println("JPQL: Java Persistence Query Language");
        System.out.println("_____________________________________");
        List<User> allUsers = userRepository.getAllUsers();
        System.out.println("allUsers:");
        allUsers.forEach(System.out::println);

        List<User> usersByNameJpql = userRepository.getUsersByName("Mohibur");
        System.out.println("usersByNameJpql:");
        usersByNameJpql.forEach(System.out::println);

        List<User> usersByNameAndCityJpql = userRepository.getUsersByNameAndCity("Mohibur", "comilla");
        System.out.println("usersByNameAndCityJpql:");
        usersByNameAndCityJpql.forEach(System.out::println);

        // native query
        System.out.println("Native query");
        System.out.println("____________");
        System.out.println("Users by native query:");
        userRepository.getUsers().forEach(System.out::println);
    }

}
