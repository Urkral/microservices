package com.example.recommendation_service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RecommendationService {

    public Flux<Recommendation> getRecommendations(int productId) {
        // Retourne des recommandations factices (pas de BD selon le cahier des charges)
        Recommendation r1 = new Recommendation(productId, 1, "Author 1", 5, "Excellent product");
        Recommendation r2 = new Recommendation(productId, 2, "Author 2", 4, "Very good");
        Recommendation r3 = new Recommendation(productId, 3, "Author 3", 3, "Average");

        return Flux.just(r1, r2, r3);
    }
}
