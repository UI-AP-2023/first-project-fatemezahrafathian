package Model.Product;

public class FlashMemory extends InformationStorageEquipment {
    public FlashMemory(ProductCategory productCategory, String name, double price, int inventoryStatus, double waite, String dimensions, int capacity, String version){
        super(productCategory,name,price,inventoryStatus,waite,dimensions,capacity);
        this.version=version;
    }
    private String version;
    private double percent;

    @Override
    public double getPercent() {
        return percent;
    }

    @Override
    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    @Override
    public String toString() {
        return "name: " + getName() + "       "+
                "price: " + getPrice();
    }
    public String toString0() {
        return "name: " + getName() + "\n" +
                "productId: " + getProductID() + "\n" +
                "category: " + getProductCategory() + "\n" +
                "price: " + getPrice() + "\n" +
                "score: " + getAverageScoreOfBuyers() + "\n" +
                "capacity=" + getCapacity() +"\n" +
                "waite=" + getWaite() +"\n" +
                ", dimensions='" + getDimensions() + "\n" +
                "inventory status: " + getInventoryStatus() + "\n"+
                "version='" + version;
    }

    @Override
    public void addDiscount(double discountPercent) {
        percent=discountPercent;
        setPrice(getPrice()-getPrice()*percent/100);
    }

    @Override
    public void deleteDiscount() {
        if (!(percent==0))
            setPrice(getPrice()*100/(100-percent));
    }
}
