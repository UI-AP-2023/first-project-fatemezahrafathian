package View;

import java.util.Scanner;
public class ViewLogIn {
    Scanner scanner = new Scanner(System.in);
    public void visitLogInPage(){
        System.out.println("Log in...! ");
        System.out.println("-------------------------------------------");
    }
    public String getUserName(){
        System.out.println("Enter username: ");
        return scanner.nextLine();
    }
    public String getPassword(){
        System.out.println("Enter password: ");
        return scanner.nextLine();
    }
    public void errorUserNameOrPassword(){
        System.out.println("The username or password entered is incorrect!");
    }
    public void choice(){
        System.out.println("-------------------------------------------");
        System.out.println("[1]Log in");
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
}
