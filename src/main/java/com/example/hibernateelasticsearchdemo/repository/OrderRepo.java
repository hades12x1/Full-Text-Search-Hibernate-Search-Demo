package com.example.hibernateelasticsearchdemo.repository;

import com.example.hibernateelasticsearchdemo.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {

    @Query(value = "SELECT o FROM Order o WHERE o.user.name LIKE %:name%")
    List<Order> findAllByUserName(@Param("name") String name);
}
