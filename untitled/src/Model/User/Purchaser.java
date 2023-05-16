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
        String information = "username: " + this.getUserName() + "\n" +
                "password: " + this.getPassword() + "\n" +
                "email: " + this.getEmail() + "\n" +
                "phone number: " + this.getPhoneNumber() + "\n" +
                "accountCredentials: " + this.getAccountCredentials() + "\n";
        return information;
    }

}
