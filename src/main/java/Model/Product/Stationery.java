package Model.Product;

public abstract class Stationery extends Product {
    public Stationery(ProductCategory productCategory, String name, double price, int inventoryStatus, String producingCountry){
        super(productCategory,name,price,inventoryStatus);
        this.producingCountry=producingCountry;
    }
    private String producingCountry;
    public String getProducingCountry() {
        return producingCountry;
    }
    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "producingCountry='" + producingCountry + '\n' +
                '}';
    }
}