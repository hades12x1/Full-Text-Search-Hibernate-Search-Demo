package com.example.hibernateelasticsearchdemo.service;

import com.example.hibernateelasticsearchdemo.repository.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final EntityManager em;

    @Transactional
    public void findUserContainOrderID(String orderId) {
        SearchSession searchSession = Search.session(em);

        SearchResult<User> result = searchSession.search(User.class)
                .where( f -> f.match().field("orders.orderId").matching(orderId))
                .fetch(10);

        long totalHitCount = result.total().hitCount();
        List<User> hits = result.hits();
        System.out.println("Total hits: " + hits.get(0).getId());
    }

    @Transactional
    public void findUsersByName(String name) {
        SearchSession searchSession = Search.session(em);

        List<User> result = searchSession.search(User.class)
                .where( f -> f.match().field("name").matching(name))
                .fetchAllHits();

        System.out.println("Total record: " + result.size());

    }

    @Transactional
    public void findUsersByEmail(String email) {
        SearchSession searchSession = Search.session(em);

        List<User> result = searchSession.search(User.class)
                .where( f -> f.match().field("email").matching(email))
                .fetchAllHits();

        System.out.println("Total record: " + result.size());

    }
}
