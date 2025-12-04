package micro.service.composite;

import micro.service.composite.CompositeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
