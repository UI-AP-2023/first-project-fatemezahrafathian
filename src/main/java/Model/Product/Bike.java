package Model.Product;

public class Bike extends Vehicle {
    public Bike(ProductCategory productCategory, String name, double price, int inventoryStatus, String companyName, BikeType bikeType){
        super(productCategory,name,price,inventoryStatus,companyName);
        this.bikeType=bikeType;
    }
    private BikeType bikeType;

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return "name: " + getName() + "    " +
                "price: " + getPrice();
    }
    public String toString0() {
        return "name: " + getName() + "\n" +
                "productId: " + getProductID() + "\n" +
                "category: " + getProductCategory() + "\n" +
                "price: " + getPrice() + "\n" +
                "score: " + getAverageScoreOfBuyers() + "\n" +
                "inventory status: " + getInventoryStatus() + "\n"+
                "companyName='" + getCompanyName() + '\n' +
                "bikeType=" + bikeType +
                '}';
    }
}
