package Model.User;

import java.util.ArrayList;

public class Purchaser extends Account {
    public Purchaser(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
    }
    //*************************************************************************

    private ArrayList<PurchaseInvoice> purchaseHistory = new ArrayList<>();
    private double accountCredentials;
    private ArrayList<DiscountCode> discountCodes = new ArrayList<>();

    //*************************************************************************
    CartClass cart= new CartClass();

    public CartClass getCart() {
        return cart;
    }

    public void setCart(CartClass cart) {
        this.cart = cart;
    }

    public void setDiscountCodes(ArrayList<DiscountCode> discountCodes) {
        this.discountCodes = discountCodes;
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

    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public String toString(){
        String information = "username:                  " + this.getUserName() + "\n\n" +
                "password:                  " + this.getPassword() + "\n\n" +
                "email:                  " + this.getEmail() + "\n\n"+
                "phone number:                  " + this.getPhoneNumber() + "\n\n" +
                "accountCredentials:                  " + this.getAccountCredentials() + "\n\n";
        return information;
    }

}
