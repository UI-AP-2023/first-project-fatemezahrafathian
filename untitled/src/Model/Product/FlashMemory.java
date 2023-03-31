package Model.Product;

public class FlashMemory extends InformationStorageEquipment {
    public FlashMemory(ProductCategory productCategory, String name, double price, String inventoryStatus, double waite, String dimensions, int capacity, String version){
        super(productCategory,name,price,inventoryStatus,waite,dimensions,capacity);
        this.version=version;
    }
    private String version;
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}
