package Model.Product;
public class Pen extends Stationery {
    public Pen(ProductCategory productCategory, String name, double price, int inventoryStatus, String producingCountry, String color){
        super(productCategory,name,price,inventoryStatus,producingCountry);
        this.color=color;
    }
    private String color;
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
}
