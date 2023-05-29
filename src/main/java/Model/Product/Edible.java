package Model.Product;

public class Edible extends Product {
    public Edible(ProductCategory productCategory, String name, double price, int inventoryStatus, String productionDate, String expirationDate){
        super(productCategory,name,price,inventoryStatus);
        this.productionDate=productionDate;
        this.expirationDate=expirationDate;
    }
    private String productionDate;
    private String expirationDate;
    public String getProductionDate() {
        return productionDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return  "name: " + getName() + "     " +
                "price: " + getPrice();
    }
    public String toString0() {
        return "Edible{" +
                "name: " + getName() + "\n" +
                "productId: " + getProductID() + "\n" +
                "category: " + getProductCategory() + "\n" +
                "price: " + getPrice() + "\n" +
                "score: " + getAverageScoreOfBuyers() + "\n" +
                "inventory status: " + getInventoryStatus() + "\n"+
                "productionDate='" + productionDate + '\n' +
                ", expirationDate='" + expirationDate;
    }
}
