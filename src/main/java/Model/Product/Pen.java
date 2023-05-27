package Model.Product;

import Model.User.DiscountFeature;

public class Pen extends Stationery implements DiscountFeature {
    public Pen(ProductCategory productCategory, String name, double price, int inventoryStatus, String producingCountry, String color){
        super(productCategory,name,price,inventoryStatus,producingCountry);
        this.color=color;
    }
    private String color;
    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
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
