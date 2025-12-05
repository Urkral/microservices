package micro.service.product;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "products")
public class Product {

    @Id
    private Integer productID;

    private String name;

    private double weight;

    public Product() {
    }

    public Product(Integer productID, String name, double weight) {
        this.productID = productID;
        this.name = name;
        this.weight = weight;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
