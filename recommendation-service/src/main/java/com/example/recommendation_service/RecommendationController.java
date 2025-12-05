package com.example.recommendation_service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_NDJSON_VALUE
    })
    public Flux<Recommendation> getRecommendations(@RequestParam int productId) {
        return service.getRecommendations(productId);
    }

    @PostMapping
    public Mono<Recommendation> createRecommendation(@RequestBody Recommendation body) {
        return service.createRecommendation(body);
    }

    @DeleteMapping("/{recommendationId}")
    public Mono<ResponseEntity<Void>> deleteRecommendation(@PathVariable int recommendationId) {
        return service.deleteRecommendation(recommendationId)
                .thenReturn(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/product/{productId}")
    public Mono<ResponseEntity<Void>> deleteByProduct(@PathVariable int productId) {
        return service.deleteRecommendationsByProductId(productId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
