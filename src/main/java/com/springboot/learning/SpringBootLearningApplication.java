package com.springboot.learning;

import com.springboot.learning.entity.User;
import com.springboot.learning.repositoy.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        // create
        // single create
        User user = new User();
        user.setName("Mohibur");
        user.setCity("Comilla");
        user.setStatus("Java Developer");
        userRepository.save(user);

        // list create
        User user1 = new User();
        user1.setName("Hasan");
        user1.setCity("Comilla");
        user1.setStatus("Angular Developer");

        User user2 = new User();
        user2.setName("Mojahid");
        user2.setCity("Narayongonj");
        user2.setStatus("Ruby Developer");
        List<User> userList = List.of(user1, user2);

        userRepository.saveAll(userList);


        // read
        // single read
        Optional<User> optionalUser = userRepository.findById(1);
        optionalUser.ifPresent(userObj -> System.out.println("User is present with id 1"));

        // all read
        Iterable<User> users = userRepository.findAll();
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }


        // update
        users.forEach(userObj -> {
            userObj.setStatus("updated status");
            userRepository.save(userObj);
        });


        // delete
        // single delete
        try {
            userRepository.deleteById(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // all delete
        userRepository.deleteAll(users);
    }

}
