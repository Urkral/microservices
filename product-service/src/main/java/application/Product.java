package application;

public class Product {

    private int ProductId;

    private String Name;

    private double Weight;

    public Product() {
    }

    public Product(int productID, String name, double weight) {
        this.ProductId = productID;
        this.Name = name;
        this.Weight = weight;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productID) {
        this.ProductId = productID;
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
