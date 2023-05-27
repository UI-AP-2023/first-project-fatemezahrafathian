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
        return "Car{" +
                "engineVolume=" + engineVolume +
                ", automatic=" + automatic +
                '}';
    }
}
