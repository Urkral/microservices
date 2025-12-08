package micro.service.composite;

import micro.service.composite.CompositeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@RestController
public class CompositeController {

    private final CompositeService compositeService;

    public CompositeController(CompositeService compositeService) {
        this.compositeService = compositeService;
    }

    @GetMapping("/product-composite/{productId}")
    public Map<String, Object> getProductComposite(@PathVariable int productId) {
        return compositeService.getProductComposite(productId);
    }

    @PostMapping("/product-composite/{productId}/reviews")
    public ResponseEntity<JsonNode> createReview(
            @PathVariable int productId,
            @RequestBody ObjectNode reviewPayload) {

        JsonNode created = compositeService.createReview(productId, reviewPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/product-composite/{productId}/recommendations")
    public ResponseEntity<JsonNode> createRecommendation(
            @PathVariable int productId,
            @RequestBody ObjectNode recommendationPayload) {

        JsonNode created = compositeService.createRecommendation(productId, recommendationPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
