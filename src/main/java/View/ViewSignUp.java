package View;
import java.util.Scanner;
public class ViewSignUp {
    Scanner scanner = new Scanner(System.in);
    public void visitSignUpPage(){
        System.out.println("Sign up...! ");
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
    public String getPhoneNumber(){
        System.out.println("Enter phone number: ");
        return scanner.nextLine();
    }
    public String getEmail(){
        System.out.println("Enter email: ");
        return scanner.nextLine();
    }
    public void errorUserName(){
        System.out.println("Username is invalid.... ");
    }
    public void errorPassword(){
        System.out.println("Password is invalid..... ");
    }
    public void errorPhoneNumber(){
        System.out.println("Phone number is invalid.... ");
    }
    public void errorEmail(){
        System.out.println("Email is invalid..... ");
    }
    public void sendRequest(){
        System.out.println("Your request has been sent to the admin.");}
}
