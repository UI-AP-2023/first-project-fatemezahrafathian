package Model;

import Model.Product.Product;

import java.util.ArrayList;

public class SystemController {
    private static ArrayList<Product> products = new ArrayList<>();

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products0) {
        products = products0;
    }

    private static boolean login=false;

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login0) {
        login = login0;
    }

    public static Product getProduct() {
        return product;
    }

    public static void setProduct(Product product) {
        SystemController.product = product;
    }

    public static Product product;
    private static int numberOfProduct;

    public static int getNumberOfProduct() {
        return numberOfProduct;
    }

    public static void setNumberOfProduct(int numberOfProduct) {
        SystemController.numberOfProduct = numberOfProduct;
    }
}
