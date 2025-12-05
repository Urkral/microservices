package com.example.recommendation_service;

import com.example.recommendation_service.RecommendationMapper;
import com.example.recommendation_service.RecommendationEntity;
import com.example.recommendation_service.RecommendationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

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
        List<RecommendationEntity> entities = repository.findByProductId(productId);
        return Flux.fromIterable(mapper.entityListToApiList(entities));
    }

    public Recommendation createRecommendation(Recommendation recommendation) {
        RecommendationEntity entity = mapper.apiToEntity(recommendation);
        RecommendationEntity saved = repository.save(entity);
        return mapper.entityToApi(saved);
    }

    public void deleteRecommendation(int recommendationId) {
        repository.deleteById(recommendationId);
    }

    public void deleteRecommendationsByProductId(int productId) {
        repository.deleteByProductId(productId);
    }
}
