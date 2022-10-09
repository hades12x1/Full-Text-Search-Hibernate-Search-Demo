package com.example.hibernateelasticsearchdemo.repository.model;

import com.example.hibernateelasticsearchdemo.repository.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private static final long serialVersionUID = 5522185857208981474L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String productName;
    private Double price;
    private Double quantity;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.LAZY)
    private List<Order> order = new ArrayList<>();

    @CreatedDate
    private Instant creationDate;
}
