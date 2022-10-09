package com.example.hibernateelasticsearchdemo.service;

import com.example.hibernateelasticsearchdemo.repository.model.Order;
import com.example.hibernateelasticsearchdemo.repository.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexingService {

    private final EntityManager em;

     @Transactional
     public void initiateIndexing() throws InterruptedException {
         log.info("Initiating indexing...");
         SearchSession searchSession = Search.session(em);
         MassIndexer indexer = searchSession.massIndexer(User.class).threadsToLoadObjects(7);
         indexer.startAndWait();
         log.info("All entities indexed");
     }
}