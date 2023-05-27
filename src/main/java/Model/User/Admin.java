package Model.User;

import Model.Product.*;

import java.util.ArrayList;

public class Admin extends Account {
    //singleton............................................................
    private Admin() {
        super("Admin", null, "0", "Admin");

    }
    public void addProducts(){

        products.add(edible);
        products.add(bike);
        products.add(car);
    }

    private static Admin admin= new Admin();

    public static Admin getAdmin() {
        return admin;
    }

    //********************************************************************
    private ArrayList<Product> products = new ArrayList<>();
    Bike bike = new Bike(ProductCategory.VEHICLES,"asd",78.2,2,"a",BikeType.URBAN);
    Car car = new Car(ProductCategory.VEHICLES,"asd",789.3,1,"fhh",78.3,true);
    Edible edible = new Edible(ProductCategory.EDIBLE,"asdfghj",45.3,1,"kjh","jjjj");

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

    @Override
    public String toString() {
        return "Admin{" +
                "products=" + products +
                ", requests=" + requests +
                '}';
    }
}
