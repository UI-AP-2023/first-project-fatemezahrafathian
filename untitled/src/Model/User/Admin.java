package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class Admin extends Account {
    //singleton............................................................
    private Admin() {
        super("Admin", null, "0", "Admin");
    }

    private static Admin admin= new Admin();

    public static Admin getAdmin() {
        return admin;
    }

    //********************************************************************
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Request> requests = new ArrayList<>();

    //*********************************************************************
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Request> getRequests() {
        return this.requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

}
