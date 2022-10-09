package com.example.hibernateelasticsearchdemo.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Indexed(index = "idx_user")
@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static final long serialVersionUID = 5522175857108981474L;

    @Id
    private int id;

    @FullTextField
    private String name;

    @KeywordField
    private String email;

    private String address;

    @IndexedEmbedded
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    private Instant creationDate;
    private Instant updatedDate;
}
