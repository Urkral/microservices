package application;

import application.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository,
            ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Product> getAllProducts() {
        List<ProductDocument> docs = repository.findAll();
        return mapper.documentListToApiList(docs);
    }

    public Optional<Product> getProductById(int id) {
        return repository.findById(id)
                .map(mapper::documentToApi);
    }

    public Product createProduct(Product product) {
        ProductDocument doc = mapper.apiToDocument(product);
        ProductDocument saved = repository.save(doc);
        return mapper.documentToApi(saved);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}