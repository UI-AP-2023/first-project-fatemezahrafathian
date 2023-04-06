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
}
