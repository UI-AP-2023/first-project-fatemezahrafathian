package Model.Product;

public abstract class InformationStorageEquipment extends DigitalGoods {
    public InformationStorageEquipment(ProductCategory productCategory, String name, double price, int inventoryStatus, double waite, String dimensions, int capacity){
        super(productCategory,name,price,inventoryStatus,waite,dimensions);
        this.capacity=capacity;
    }
    private int capacity;
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "InformationStorageEquipment{" +
                "capacity=" + capacity +
                '}';
    }
}
