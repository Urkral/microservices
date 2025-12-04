package application;

public class Product {

    private int ProductID;

    private String Name;

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
