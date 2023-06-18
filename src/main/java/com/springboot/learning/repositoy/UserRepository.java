package com.springboot.learning.repositoy;

import com.springboot.learning.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // custom finder
    List<User> findByName(String name);

    List<User> findByCity(String city);

    List<User> findByNameAndCity(String name, String city);

    // jpql
    @Query("select u from User u")
    List<User> getAllUsers();

    @Query("select u from User u where u.name = :n")
    List<User> getUsersByName(@Param("n") String name);

    @Query("select u from User u where u.name = :n and u.city = :c")
    List<User> getUsersByNameAndCity(@Param("n") String name, @Param("c") String city);

    // native query
    @Query(value = "select * from user", nativeQuery = true)
    List<User> getUsers();
}
