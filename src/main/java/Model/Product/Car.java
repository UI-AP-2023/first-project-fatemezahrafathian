package Model.Product;
public class Car extends Vehicle {
    public Car(ProductCategory productCategory, String name, double price, int inventoryStatus, String companyName, double engineVolume, boolean automatic){
        super(productCategory,name,price,inventoryStatus,companyName);
        this.engineVolume=engineVolume;
        this.automatic=automatic;
    }
    private double engineVolume;
    private boolean automatic;
    public boolean isAutomatic() {
        return automatic;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }
    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
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
                "engineVolume=" + engineVolume+ '\n'+
                ", automatic=" + automatic;
    }
}
