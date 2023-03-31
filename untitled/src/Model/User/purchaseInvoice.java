package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class purchaseInvoice {
    //constructor...................................
    private String invoiceID;
    private String date;
    private int amountPaid;
    private ArrayList<Product> listOfPurchasedGoods = new ArrayList<>();
    public String getInvoiceID() {
        return invoiceID;
    }
    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }
    public ArrayList<Product> getListOfPurchasedGoods() {
        return listOfPurchasedGoods;
    }
    public void setListOfPurchasedGoods(ArrayList<Product> listOfPurchasedGoods) {
        this.listOfPurchasedGoods = listOfPurchasedGoods;
    }
}
