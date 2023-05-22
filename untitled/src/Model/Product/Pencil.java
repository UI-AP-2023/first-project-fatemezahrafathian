package Model.Product;

import Model.User.DiscountFeature;

public class Pencil extends Stationery implements DiscountFeature {
    public Pencil(ProductCategory productCategory, String name, double price, int inventoryStatus, String producingCountry, PencilType pencilType){
        super(productCategory,name,price,inventoryStatus,producingCountry);
        this.pencilType=pencilType;
    }
    private PencilType pencilType;
    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public PencilType getPencilType() {
        return pencilType;
    }
    public void setPencilType(PencilType pencilType) {
        this.pencilType = pencilType;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "pencilType=" + pencilType +
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
