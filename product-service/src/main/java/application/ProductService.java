package application;

import application.Product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Tralalero Tralala", 0.25));
        list.add(new Product(2, "Bombardino Crocodilo", 0.20));
        list.add(new Product(3, "Tung Tung Tung Sahur", 0.05));
        this.products = Collections.unmodifiableList(list);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(int productId) {
        return products.stream()
                .filter(p -> p.getProductID() == productId)
                .findFirst();
    }
}
