package Model.Product;

public class PersonalComputer extends DigitalGoods {
    public PersonalComputer(ProductCategory productCategory, String name, double price, String inventoryStatus, double waite, String dimensions, String cpuModel, int ramCapacity){
        super(productCategory,name,price,inventoryStatus,waite,dimensions);
        this.cpuModel =cpuModel;
        this.ramCapacity =ramCapacity;
    }
    private String cpuModel;
    private int ramCapacity;
    public String getCpuModel() {
        return cpuModel;
    }
    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }
    public int getRamCapacity() {
        return ramCapacity;
    }
    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }
}
