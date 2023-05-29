package Model.User;

import Model.Product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PurchaseInvoice {
    private static  int number=0;
    public PurchaseInvoice(LocalDate date){
        number++;
        this.date=date;
        this.invoiceID="a-"+date+"-"+number;
    }
    //constructor...................................
    private String invoiceID;
    private LocalDate date;
    private double amountPaid;
    private HashMap<Product,Integer> listOfPurchasedGoods = new HashMap<>();
    public String getInvoiceID() {
        return invoiceID;
    }
    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public HashMap<Product, Integer> getListOfPurchasedGoods() {
        return listOfPurchasedGoods;
    }
    public void setListOfPurchasedGoods(HashMap<Product, Integer> listOfPurchasedGoods) {
        this.listOfPurchasedGoods = listOfPurchasedGoods;
    }

    @Override
    public String toString() {
        return invoiceID;
    }

    public String toString0() {
        ArrayList<String> products = new ArrayList<>();
        for (Product product:listOfPurchasedGoods.keySet()){
            products.add(product.getName()+"            "+product.getPrice()+"\n");
        }
        return "invoiceID='               " + invoiceID + "\n\n" +
                ", date=               " + date +"\n\n" +
                ", amountPaid=               " + amountPaid +"\n\n"+
                "products:"+"\n\n"+products;

    }
}
