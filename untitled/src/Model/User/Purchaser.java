package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class Purchaser extends Account {
    public Purchaser(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }
    //*************************************************************************
    private ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<purchaseInvoice> purchaseHistory = new ArrayList<>();
    private double accountCredentials;

    //*************************************************************************
    public ArrayList<Product> getCart() {
        return this.cart;
    }
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public ArrayList<purchaseInvoice> getPurchaseHistory() {
        return this.purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<purchaseInvoice> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public double getAccountCredentials() {
        return this.accountCredentials;
    }

    public void setAccountCredentials(double accountCredentials) {
        this.accountCredentials = accountCredentials;
    }
    @Override
    public boolean equals(Object object){

        if(this.getUserName() == object.toString())
            return true;
        else return false;
    }
    public String toString(){
        StringBuilder information = new StringBuilder();
        information.append("username: "+this.getUserName()+"\n");
        information.append("password: "+this.getPassword()+"\n");
        information.append("email: "+this.getEmail()+"\n");
        information.append("phone number: "+this.getPhoneNumber()+"\n");
        information.append("accountCredentials: "+this.getAccountCredentials()+"\n\n");
        return information.toString();
    }

}
