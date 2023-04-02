package View;
import java.util.Scanner;
public class ViewEnterPage {
    public void visitEnterPage(){
        System.out.println("Welcome...! ");
        System.out.println("-------------------------------------------");
        System.out.println("[1]Sign up");
        System.out.println("[2]Log in");
        System.out.println("[3]Products");
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