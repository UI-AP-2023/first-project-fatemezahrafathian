package Model.Product;

public abstract class Vehicle extends Product {
    public Vehicle(ProductCategory productCategory, String name, double price, int inventoryStatus, String companyName){
       super(productCategory,name,price,inventoryStatus);
       this.companyName=companyName;
    }
    private String companyName;
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
