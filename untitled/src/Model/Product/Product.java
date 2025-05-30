package Model.Product;
import Model.User.Comment;

import java.util.ArrayList;
public abstract class Product {
    public Product(ProductCategory productCategory, String name, double price, int inventoryStatus){
        this.name=name;
        this.price=price;
        this.productCategory=productCategory;
        this.inventoryStatus=inventoryStatus;
        this.ProductID = createProductID();
    }
    private static int numberOfProducts;
    private String createProductID(){
        numberOfProducts++;
        return productCategory.name().substring(0, 2)+"-"+ name.charAt(0) +"-"+numberOfProducts;
    }
    private final String ProductID;
    private String name;
    private double price;
    private ProductCategory productCategory;
    private int inventoryStatus;
    private double averageScoreOfBuyers;
    private int numberOfPurchaserThatAddScore=0;
    private ArrayList<Comment> comments = new ArrayList<>();
    public String getName() {
        return name;
    }
    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public String getProductID() {
        return ProductID;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public double getAverageScoreOfBuyers() {
        return averageScoreOfBuyers;
    }
    public double getPrice() {
        return price;
    }
    public int getInventoryStatus() {
        return inventoryStatus;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public void setInventoryStatus(int inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public void setAverageScoreOfBuyers(double averageScoreOfBuyers) {
        this.averageScoreOfBuyers = averageScoreOfBuyers;
    }
    public int getNumberOfPurchaserThatAddScore() {
        return numberOfPurchaserThatAddScore;
    }
    public void setNumberOfPurchaserThatAddScore(int numberOfPurchaserThatAddScore) {
        this.numberOfPurchaserThatAddScore = numberOfPurchaserThatAddScore;
    }
    public String toString(){
        String productInformation = "name: " + getName() + "\n" +
                "productId: " + getProductID() + "\n" +
                "category: " + getProductCategory() + "\n" +
                "price: " + getPrice() + "\n" +
                "score: " + getAverageScoreOfBuyers() + "\n" +
                "inventory status: " + getInventoryStatus() + "\n";
        return productInformation;
    }
}