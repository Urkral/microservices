package micro.service.composite;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CompositeService {

    private final RestTemplate restTemplate;

    @Value("${app.product-service-url}")
    private String productServiceUrl;

    @Value("${app.review-service-url}")
    private String reviewServiceUrl;

    @Value("${app.recommendation-service-url}")
    private String recommendationServiceUrl;

    public CompositeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getProductComposite(int productId) {

        // Call 3 microservices and get raw JSON trees
        JsonNode product =
                restTemplate.getForObject(productServiceUrl, JsonNode.class, productId);

        JsonNode reviews =
                restTemplate.getForObject(reviewServiceUrl, JsonNode.class, productId);

        JsonNode recommendations =
                restTemplate.getForObject(recommendationServiceUrl, JsonNode.class, productId);

        // Build one aggregated JSON object
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("product", product);
        result.put("reviews", reviews);
        result.put("recommendations", recommendations);

        return result;
    }
}
