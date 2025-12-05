package com.example.recommendation_service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository
        extends JpaRepository<RecommendationEntity, Integer> {

    List<RecommendationEntity> findByProductId(int productId);

    void deleteByProductId(int productId);
}
