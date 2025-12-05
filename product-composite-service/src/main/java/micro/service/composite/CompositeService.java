package micro.service.composite;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CompositeService {

    private final RestTemplate restTemplate;
    private final WebClient webClient;

    private static final String PRODUCT_SERVICE_URL = "http://product-service";
    private static final String REVIEW_SERVICE_URL = "http://review-service";
    private static final String RECOMMENDATION_SERVICE_URL = "http://recommendation-service";

    public CompositeService(WebClient.Builder webClientBuilder, RestTemplate restTemplate) {
        this.webClient = webClientBuilder.build();
        this.restTemplate = restTemplate;
    }

    /**
     * Calls product, review and recommendation microservices through
     * Eureka + client-side load balancing and aggregates the result.
     */
    public Map<String, Object> getProductComposite(int productId) {

        JsonNode product = restTemplate.getForObject(
                PRODUCT_SERVICE_URL + "/product/{id}", JsonNode.class, productId);

        JsonNode reviews = restTemplate.getForObject(
                REVIEW_SERVICE_URL + "/reviews/product/{productId}", JsonNode.class, productId);

        JsonNode recommendations = restTemplate.getForObject(
                RECOMMENDATION_SERVICE_URL + "/recommendation?productId={productId}", JsonNode.class, productId);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("product", product);
        result.put("reviews", reviews);
        result.put("recommendations", recommendations);

        return result;
    }
}
