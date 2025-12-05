package com.example.recommendation_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService service;

    @Autowired
    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    // GET /recommendation?productId=1
    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_NDJSON_VALUE
    })
    public Flux<Recommendation> getRecommendations(@RequestParam int productId) {
        return service.getRecommendations(productId);
    }

    // POST /recommendation
    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation body) {
        return service.createRecommendation(body);
    }

    // DELETE /recommendation/{recommendationId}
    @DeleteMapping("/{recommendationId}")
    public ResponseEntity<Void> deleteRecommendation(
            @PathVariable int recommendationId) {
        service.deleteRecommendation(recommendationId);
        return ResponseEntity.noContent().build();
    }

    // DELETE /recommendation/product/{productId}
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteRecommendationsByProduct(
            @PathVariable int productId) {
        service.deleteRecommendationsByProductId(productId);
        return ResponseEntity.noContent().build();
    }
}
