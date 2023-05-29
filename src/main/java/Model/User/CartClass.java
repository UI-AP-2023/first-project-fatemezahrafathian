package Model.User;

import Model.Product.Product;

import java.util.ArrayList;

public class CartClass {
    private double price=0;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private ArrayList<Product> cart = new ArrayList<>();
    public ArrayList<Product> getCart() {
        return this.cart;
    }
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
