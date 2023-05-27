package Model.Product;

import Model.User.DiscountFeature;

public abstract class DigitalGoods extends Product implements DiscountFeature {
    public DigitalGoods(ProductCategory productCategory, String name, double price, int inventoryStatus, double waite, String dimensions){
        super(productCategory,name,price,inventoryStatus);
        this.waite=waite;
        this.dimensions=dimensions;
    }
    private double waite;
    private String dimensions;
    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

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

    @Override
    public String toString() {
        return "DigitalGoods{" +
                "waite=" + waite +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }
}
