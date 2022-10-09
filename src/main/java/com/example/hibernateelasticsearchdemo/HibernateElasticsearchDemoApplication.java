package com.example.hibernateelasticsearchdemo;

import com.example.hibernateelasticsearchdemo.repository.UserRepo;
import com.example.hibernateelasticsearchdemo.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernateElasticsearchDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cx = SpringApplication.run(HibernateElasticsearchDemoApplication.class, args);

        TestService testService = cx.getBean(TestService.class);
        UserRepo userRepo = cx.getBean(UserRepo.class);

        // index manual
        // cx.getBean(IndexingService.class).initiateIndexing();

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            System.out.println(userRepo.findUserContainOrderID("Order 397 - 395").getId());
            System.out.println("Time normal: " + (System.currentTimeMillis() - start));
        }

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            testService.findUserContainOrderID("Order 397 - 395");
            System.out.println("Time ES: " + (System.currentTimeMillis() - start));
        }

        System.out.println("======SEARCH LIKE======");
        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            System.out.println(userRepo.findUsersByName("User 39").size());
            System.out.println("Time normal: " + (System.currentTimeMillis() - start));
        }

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            testService.findUsersByName("User 39");
            System.out.println("Time ES: " + (System.currentTimeMillis() - start));
        }

        System.out.println("======SEARCH EQUAL======");
        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            System.out.println(userRepo.findUsersByEmail("user394@gmail.com").size());
            System.out.println("Time normal: " + (System.currentTimeMillis() - start));
        }

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            testService.findUsersByEmail("user394@gmail.com");
            System.out.println("Time ES: " + (System.currentTimeMillis() - start));
        }
    }
}
