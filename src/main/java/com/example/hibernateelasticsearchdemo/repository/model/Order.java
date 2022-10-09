package com.example.hibernateelasticsearchdemo.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private static final long serialVersionUID = 5522175857208981474L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @KeywordField
    private String orderId;
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    @CreatedDate
    private Instant creationDate;

    @LastModifiedDate
    private Instant updatedDate;
}
