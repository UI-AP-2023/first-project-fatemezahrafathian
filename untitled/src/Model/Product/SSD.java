package Model.Product;

public class SSD extends InformationStorageEquipment {
    public SSD(ProductCategory productCategory, String name, double price, int inventoryStatus, double waite, String dimensions, int capacity, double readingSpeed, double writingSpeed){
        super(productCategory,name,price,inventoryStatus,waite,dimensions,capacity);
        this.readingSpeed=readingSpeed;
        this.writingSpeed=writingSpeed;
    }
    private double readingSpeed;
    private double writingSpeed;
    public double getReadingSpeed() {
        return readingSpeed;
    }
    public double getWritingSpeed() {
        return writingSpeed;
    }
    public void setReadingSpeed(double readingSpeed) {
        this.readingSpeed = readingSpeed;
    }
    public void setWritingSpeed(double writingSpeed) {
        this.writingSpeed = writingSpeed;
    }
}
