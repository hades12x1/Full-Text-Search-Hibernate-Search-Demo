package com.example.hibernateelasticsearchdemo.repository;

import com.example.hibernateelasticsearchdemo.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "select u.id from users u order by u.creation_date desc limit 1", nativeQuery = true)
    Integer getLastIdentity();

    @Query(value = "select u from User u join fetch u.orders o WHERE o.orderId = ?1")
    User findUserContainOrderID(String orderID);

    @Query(value = "select distinct u from User u join fetch u.orders o WHERE u.name like %?1%")
    List<User> findUsersByName(String name);

    @Query(value = "select distinct u from User u join fetch u.orders o WHERE u.email like %?1%")
    List<User> findUsersByEmail(String email);
}
