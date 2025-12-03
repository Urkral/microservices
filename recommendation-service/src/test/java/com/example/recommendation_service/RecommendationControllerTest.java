package com.example.recommendation_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getRecommendationsShouldReturnList() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/recommendation").queryParam("productId", 1).build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Recommendation.class).hasSize(3);
    }
}
