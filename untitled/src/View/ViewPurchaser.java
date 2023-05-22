package View;

import Model.Product.Product;
import Model.User.Purchaser;

import java.util.Scanner;

public class ViewPurchaser {
    Scanner scanner = new Scanner(System.in);
    public void choice(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]edit information");
        System.out.println("[2]visit products");
        System.out.println("[3]filter");
        System.out.println("[4]buy product");
        System.out.println("[5]visit history");
        System.out.println("[6]add comment");
        System.out.println("[7]add score");
        System.out.println("[8]top of user account credit");
        System.out.println("[9]visit cart");
        System.out.println("[0]Exit");
    }
    public String enterDiscountCode(){
        System.out.println("please discount code?\n");
        return scanner.nextLine();
    }
    public void useDiscountCode(){
        System.out.println("are you want that use discount code?\n");
        System.out.println("[1]yes       [2]no \n");
    }
    public void visitCart(Purchaser purchaser){
        for (Product product : purchaser.getCart()){
            System.out.println(product.toString());
        }
    }
    public int enterChoice(){
        System.out.println("Please enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public String getId(){
        System.out.println("enter product field: ");
        return scanner.nextLine();}
    public String getComment(){
        System.out.println("enter comment: ");
        return scanner.nextLine();}
    public int getPoint() {
        System.out.println("enter product point: ");
        int point = scanner.nextInt();
        if (point>=0 && point<=5){
            return point;
        }
        else return 0;
    }
    public void error(){
        System.out.println("The entered number is invalid...");
    }
    public void editInformation(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]edit password");
        System.out.println("[2]edit email");
        System.out.println("[3]edit phone number");
        System.out.println("[0]Exit");
    }
    public String getNumberOfCart(){
        System.out.println("enter number of your cart: ");
        return scanner.next();
    }
    public String getPasswordCart(){
        System.out.println("enter  your password: ");
        return scanner.next();
    }
    public String getCvv2(){
        System.out.println("enter  your cvv2 ");
        return scanner.next();
    }
    public double getAmount(){
        System.out.println("enter  amount: ");
        return scanner.nextDouble();
    }
    public void errorPay(){
        System.out.println("payment was not made");
    }
    public void sendRequest(){
        System.out.println("Your request has been sent to the admin.");
    }
    public void information(String information){
        System.out.println(information);
    }
}
