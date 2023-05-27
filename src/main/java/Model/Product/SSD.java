package Model.Product;

public class SSD extends InformationStorageEquipment {
    public SSD(ProductCategory productCategory, String name, double price, int inventoryStatus, double waite, String dimensions, int capacity, double readingSpeed, double writingSpeed){
        super(productCategory,name,price,inventoryStatus,waite,dimensions,capacity);
        this.readingSpeed=readingSpeed;
        this.writingSpeed=writingSpeed;
    }
    private double readingSpeed;
    private double writingSpeed;
    private double percent;

    @Override
    public double getPercent() {
        return percent;
    }

    @Override
    public void setPercent(double percent) {
        this.percent = percent;
    }

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

    @Override
    public String toString() {
        return "SSD{" +
                "readingSpeed=" + readingSpeed +
                ", writingSpeed=" + writingSpeed +
                '}';
    }

    @Override
    public void addDiscount(double discountPercent) {
        setPrice(getPrice()-getPrice()*percent/100);
    }

    @Override
    public void deleteDiscount() {
        if (!(percent==0))
            setPrice(getPrice()*100/(100-percent));
    }
}
