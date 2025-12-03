package application;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductServiceController {

    private final List<Product> products;

    public ProductServiceController() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Tralalero Tralala", 0.25));
        list.add(new Product(2, "Bombardino Crocodilo", 0.2));
        list.add(new Product(3, "Tung Tung Tung Sahur", 0.05));
        this.products = Collections.unmodifiableList(list);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        return products.stream()
                .filter(p -> p.getProductID() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Internal DTO to keep the controller self-contained (JSON field names match requirements)
    public static class Product {
        @JsonProperty("ProductID")
        private int ProductID;

        @JsonProperty("Name")
        private String Name;

        @JsonProperty("Weight")
        private double Weight;

        public Product() {
        }

        public Product(int productID, String name, double weight) {
            this.ProductID = productID;
            this.Name = name;
            this.Weight = weight;
        }

        public int getProductID() {
            return ProductID;
        }

        public void setProductID(int productID) {
            this.ProductID = productID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public double getWeight() {
            return Weight;
        }

        public void setWeight(double weight) {
            this.Weight = weight;
        }
    }
}
