package com.example.recommendation_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initRecommendations(RecommendationRepository repository) {
        return args -> {

            repository.deleteAll().block();

            repository.saveAll(Flux.just(
                    new RecommendationDocument(1, 1, "Author 1", 5, "Excellent product"),
                    new RecommendationDocument(2, 1, "Author 2", 4, "Very good"),
                    new RecommendationDocument(3, 1, "Author 3", 3, "Average"))).blockLast();
        };
    }
}
