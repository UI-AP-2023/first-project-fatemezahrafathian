package Model.Product;

public class PersonalComputer extends DigitalGoods {
    public PersonalComputer(ProductCategory productCategory, String name, double price,int inventoryStatus, double waite, String dimensions, String cpuModel, int ramCapacity){
        super(productCategory,name,price,inventoryStatus,waite,dimensions);
        this.cpuModel =cpuModel;
        this.ramCapacity =ramCapacity;
    }
    private String cpuModel;
    private int ramCapacity;

    @Override
    public double getPercent() {
        return percent;
    }

    @Override
    public void setPercent(double percent) {
        this.percent = percent;
    }

    private double percent;
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

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "cpuModel='" + cpuModel + '\'' +
                ", ramCapacity=" + ramCapacity +
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
