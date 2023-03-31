package Model.Product;

public abstract class DigitalGoods extends Product {
    public DigitalGoods(ProductCategory productCategory, String name, double price, String inventoryStatus, double waite, String dimensions){
        super(productCategory,name,price,inventoryStatus);
        this.waite=waite;
        this.dimensions=dimensions;
    }
    private double waite;
    private String dimensions;
    public double getWaite() {
        return waite;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setWaite(double waite) {
        this.waite = waite;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
