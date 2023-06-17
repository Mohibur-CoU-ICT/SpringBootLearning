package com.springboot.learning.repositoy;

import com.springboot.learning.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByCity(String city);

    List<User> findByNameAndCity(String name, String city);
}
