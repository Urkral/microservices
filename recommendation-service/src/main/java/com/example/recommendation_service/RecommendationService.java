package com.example.recommendation_service;

import com.example.recommendation_service.RecommendationMapper;
import com.example.recommendation_service.RecommendationDocument;
import com.example.recommendation_service.RecommendationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecommendationService {

    private final RecommendationRepository repository;
    private final RecommendationMapper mapper;

    public RecommendationService(RecommendationRepository repository,
            RecommendationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<Recommendation> getRecommendations(int productId) {
        return repository.findByProductId(productId)
                .map(mapper::documentToApi);
    }

    public Mono<Recommendation> createRecommendation(Recommendation recommendation) {
        RecommendationDocument doc = mapper.apiToDocument(recommendation);
        return repository.save(doc)
                .map(mapper::documentToApi);
    }

    public Mono<Void> deleteRecommendation(int recommendationId) {
        return repository.deleteById(recommendationId);
    }

    public Mono<Void> deleteRecommendationsByProductId(int productId) {
        return repository.deleteByProductId(productId);
    }
}
