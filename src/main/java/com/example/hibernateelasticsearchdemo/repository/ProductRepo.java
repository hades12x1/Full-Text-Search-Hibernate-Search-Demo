package com.example.hibernateelasticsearchdemo.repository;

import com.example.hibernateelasticsearchdemo.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
