package Controller;

import Model.User.Account;
import Model.User.Admin;
import Model.User.Request;
import View.ViewSignUp;
import View.ViewLogIn;
import Model.User.Purchaser;

import java.util.ArrayList;
import java.util.regex.*;
public class AccountController {
    public void signUpPurchaser(){
        int choice = 1;
        while (choice != 0){
            ViewSignUp viewSignUp = new ViewSignUp();
            viewSignUp.visitSignUpPage();
            if(choice == 1){
                while (checkUsername(viewSignUp.getUserName())){
                    viewSignUp.errorUserName();
                }
                while (!checkPassword(viewSignUp.getPassword())){
                    viewSignUp.errorPassword();
                }
                while (!checkPhoneNumber(viewSignUp.getPhoneNumber())){
                    viewSignUp.errorPhoneNumber();
                }
                while (!checkEmail(viewSignUp.getEmail())){
                    viewSignUp.errorEmail();
                }
                Purchaser purchaser = new Purchaser(username,email,phoneNumber,password);
                Request request = new Request("add purchaser",purchaser);
                AdminController adminController = new AdminController();
                adminController.acceptAddPurchaser(request);
                viewSignUp.sendRequest();
            }
            else{
                viewSignUp.error();
            }
            viewSignUp.choice();
            choice=viewSignUp.enterChoice();
        }
    }
    public void logInPurchaser(){
        int choice = 1;
        while (choice != 0){
            ViewLogIn viewLogIn = new ViewLogIn();
            viewLogIn.visitLogInPage();
            if(choice == 1){
                while (!checkLogIn(viewLogIn.getUserName(),viewLogIn.getPassword())){
                    viewLogIn.errorUserNameOrPassword();
                }
                if(account instanceof Purchaser){

                }
                else if(account instanceof Admin){

                }
            }
            else{
                viewLogIn.error();
            }
            viewLogIn.choice();
            choice=viewLogIn.enterChoice();
        }
    }
    public boolean checkLogIn(String username, String password){
        boolean truePasswordAndUserName=false;
        for (Purchaser purchaser:purchasers){
            if(purchaser.getUserName().equals(username) && purchaser.getPassword().equals(password)){
                truePasswordAndUserName=true;
                this.account=purchaser;
                break;
            }
        }
        Admin admin = Admin.getAdmin();
        if(admin.getUserName().equals("Admin") && admin.getPassword().equals("Admin")){
            truePasswordAndUserName=true;
            this.account=admin;
        }
        return truePasswordAndUserName;
    }
    private ArrayList<Purchaser> purchasers = new ArrayList<>();
    private Account account;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean checkUsername(String username){
        boolean duplicateUsername=false;
        for (Purchaser purchaser: purchasers){
            if (purchaser.equals(username)) {
                duplicateUsername = true;
                break;
            }
        }
        if (!duplicateUsername){
            this.username=username;
        }
        return duplicateUsername;
    }
    private boolean checkPassword(String password){
        boolean truePassword=false;
        Pattern pattern =Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher =pattern.matcher(password);
        boolean found = matcher.find();
        if (found){
            this.password=password;
            truePassword=true;
        }
        return truePassword;
    }
    private boolean checkPhoneNumber(String phoneNumber){
        boolean truePhoneNumber=false;
        Pattern pattern =Pattern.compile("^(09)+\\d{9}$");
        Matcher matcher =pattern.matcher(phoneNumber);
        boolean found = matcher.find();
        if (found){
            this.phoneNumber=phoneNumber;
            truePhoneNumber=true;
        }
        return truePhoneNumber;
    }
    private boolean checkEmail(String email){
        boolean trueEmail=false;
        Pattern pattern =Pattern.compile("^\\w+@(gmail|yahoo)\\.com$");
        Matcher matcher =pattern.matcher(email);
        boolean found = matcher.find();
        if (found){
            this.email=email;
            trueEmail=true;
        }
        return trueEmail;
    }
    public ArrayList<Purchaser> getPurchasers() {
        return purchasers;
    }
    public void setPurchasers(ArrayList<Purchaser> purchasers) {
        this.purchasers = purchasers;
    }
}
