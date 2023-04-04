package Model.Product;

public class Pencil extends Stationery {
    public Pencil(ProductCategory productCategory, String name, double price, int inventoryStatus, String producingCountry, PencilType pencilType){
        super(productCategory,name,price,inventoryStatus,producingCountry);
        this.pencilType=pencilType;
    }
    private PencilType pencilType;
    public PencilType getPencilType() {
        return pencilType;
    }
    public void setPencilType(PencilType pencilType) {
        this.pencilType = pencilType;
    }
}
