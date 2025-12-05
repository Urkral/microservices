package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDataInitializer {

        @Bean
        public CommandLineRunner initProducts(ProductRepository repository,
                        ProductMapper mapper) {
                return args -> {
                        repository.deleteAll();

                        repository.save(mapper.apiToDocument(
                                        new Product(1, "Tralalero Tralala", 0.25)));
                        repository.save(mapper.apiToDocument(
                                        new Product(2, "Bombardino Crocodilo", 0.20)));
                        repository.save(mapper.apiToDocument(
                                        new Product(3, "Tung Tung Tung Sahur", 0.05)));
                };
        }
}
