package micro.service.product;

import micro.service.product.Product;
import micro.service.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().body("Product body is required");
        }
        if (product.getProductID() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ProductID is required");
        }
        if (productRepository.existsById(product.getProductID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Product with ID " + product.getProductID() + " already exists");
        }
        try {
            Product saved = productRepository.save(product);
            URI location = URI.create("/products/getProduct/" + saved.getProductID());
            return ResponseEntity.created(location).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save product: " + e.getMessage());
        }
    }

    @DeleteMapping("/removeProduct/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("id path variable is required");
        }
        if (!productRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with ID " + id + " not found");
        }
        try {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete product: " + e.getMessage());
        }
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("id path variable is required");
        }
        var opt = productRepository.findById(id);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with ID " + id + " not found");
        }
    }
}
