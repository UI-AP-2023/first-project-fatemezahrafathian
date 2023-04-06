package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class Purchaser extends Account {
    public Purchaser(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }
    //*************************************************************************
    private ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<PurchaseInvoice> purchaseHistory = new ArrayList<>();
    private double accountCredentials;

    //*************************************************************************
    public ArrayList<Product> getCart() {
        return this.cart;
    }
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public ArrayList<PurchaseInvoice> getPurchaseHistory() {
        return this.purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<PurchaseInvoice> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public double getAccountCredentials() {
        return this.accountCredentials;
    }

    public void setAccountCredentials(double accountCredentials) {
        this.accountCredentials = accountCredentials;
    }
    public String toString(){
        StringBuilder information = new StringBuilder();
        information.append("username: "+this.getUserName()+"\n");
        information.append("password: "+this.getPassword()+"\n");
        information.append("email: "+this.getEmail()+"\n");
        information.append("phone number: "+this.getPhoneNumber()+"\n");
        information.append("accountCredentials: "+this.getAccountCredentials()+"\n");
        return information.toString();
    }

}
