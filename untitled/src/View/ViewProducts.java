package View;

import Model.Product.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewProducts {
    Scanner scanner = new Scanner(System.in);
    public void visitPage(ArrayList<Product> products){
        for (Product product: products){
            System.out.println(product.toString());
        }
    }
    public void choice(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]select");
        System.out.println("[0]Exit");
    }
    public int enterChoice(){
        System.out.println("Please enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void error(){
        System.out.println("The entered number is invalid...");
    }
    public ProductCategory getProductCategory() {
        String productCategory = scanner.next();
        if (productCategory.equals(ProductCategory.DIGITAL_GOODS.name()))
            return ProductCategory.DIGITAL_GOODS;
        if (productCategory.equals(ProductCategory.STATIONERY.name()))
            return ProductCategory.STATIONERY;
        if (productCategory.equals(ProductCategory.VEHICLES.name()))
            return ProductCategory.VEHICLES;
        if (productCategory.equals(ProductCategory.EDIBLE.name()))
            return ProductCategory.EDIBLE;
        else return null;
    }
    public double getPrice(){
        return scanner.nextDouble();
    }
    public int getInventoryStatus(){
        return scanner.nextInt();
    }
    public String getId(){
        return scanner.next();
    }
}

