package Model.Product;

public class NoteBook extends Stationery {
    public NoteBook(ProductCategory productCategory, String name, double price, String inventoryStatus, String producingCountry, int numberOfSheets, String paperType){
        super(productCategory,name,price,inventoryStatus,producingCountry);
        this.numberOfSheets=numberOfSheets;
        this.paperType=paperType;
    }
    private int numberOfSheets;
    private String paperType;
    public int getNumberOfSheets() {
        return numberOfSheets;
    }
    public String getPaperType() {
        return paperType;
    }
    public void setNumberOfSheets(int numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }
    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
}
