package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class PurchaseInvoice {
    private static  int number=0;
    public PurchaseInvoice(String date,double amountPaid){
        number++;
        this.date=date;
        this.amountPaid=amountPaid;
        this.invoiceID="a-"+date+"-"+number;
    }
    //constructor...................................
    private String invoiceID;
    private String date;
    private double amountPaid;
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
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public ArrayList<Product> getListOfPurchasedGoods() {
        return listOfPurchasedGoods;
    }
    public void setListOfPurchasedGoods(ArrayList<Product> listOfPurchasedGoods) {
        this.listOfPurchasedGoods = listOfPurchasedGoods;
    }
    public String toString(){
        StringBuilder invoice = new StringBuilder();
        invoice.append("invoiceId: "+this.invoiceID+"\n");
        invoice.append("date: "+this.date+"\n");
        ArrayList<Product> products = new ArrayList<>();
        boolean exist=false;
        for (Product product : this.listOfPurchasedGoods){
            for (Product product1 : products){
                if (product.equals(product1)) {
                    exist = true;
                    break;
                }
            }
            if (!exist){
                products.add(product);
            }
        }
        int numberOfProduct=0;
        for (Product product : products){
            for (Product product1 : this.listOfPurchasedGoods){
                if (product.equals(product1))
                    numberOfProduct++;
            }
            invoice.append("product Name: "+product.getName()+"number of product: "+numberOfProduct+"\n");
        }
        return invoice.toString();
    }

}
