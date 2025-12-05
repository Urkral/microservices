package com.example.recommendation_service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RecommendationRepository
        extends ReactiveMongoRepository<RecommendationDocument, Integer> {

    Flux<RecommendationDocument> findByProductId(Integer productId);

    Mono<Void> deleteByProductId(Integer productId);
}
