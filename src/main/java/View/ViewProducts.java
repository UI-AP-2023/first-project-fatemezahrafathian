package View;

import Model.Product.*;
import Model.User.Comment;

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
        System.out.println("[3]select");
        System.out.println("[0]Exit");
    }
    public void choice1(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]filter");
        System.out.println("[2]search");
        System.out.println("[3]visitProducts");
        System.out.println("[0]Exit");
    }
    public void choice2(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]visit product");
        System.out.println("[2]visit comment");
        System.out.println("[3]add comment");
        System.out.println("[0]Exit");
    }
    public void choice3(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]visit product");
        System.out.println("[2]visit comment");
        System.out.println("[3]add comment");
        System.out.println("[4]add product to cart");
        System.out.println("[0]Exit");
    }

    public void visitProduct(Product product){
        System.out.println(product.toString());
    }
    public void visitProductComment(Product product){
        for (Comment comment : product.getComments()){
            System.out.println(comment.toString());
        }
    }
    public String getComment(){
        System.out.println("enter comment: ");
        return scanner.nextLine();
    }
    public void filterPage(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]filter category");
        System.out.println("[2]filter inventory status");
        System.out.println("[3]filter price");
        System.out.println("[4]filter color");
        System.out.println("[5]filter company name");
        System.out.println("[6]filter dimension");
        System.out.println("[7]filter version");
        System.out.println("[8]filter paper type");
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
    public void nextPage(){
        System.out.println("[1]next page");
    }
    public void previousPage(){
        System.out.println("[2]previous page");
    }
    public ProductCategory getProductCategory() {
        System.out.println("Please enter the category: ");
        String productCategory = scanner.nextLine();
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
        System.out.println("Please enter the price: ");
        return scanner.nextDouble();
    }
    public int getInventoryStatus(){
        System.out.println("Please enter the min inventory: ");
        return scanner.nextInt();
    }
    public String getName(){
        System.out.println("enter field of product : ");
        return scanner.next();
    }
}

