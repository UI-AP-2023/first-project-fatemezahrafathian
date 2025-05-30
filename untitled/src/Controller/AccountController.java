package Controller;

import Model.User.Account;
import Model.User.Admin;
import Model.User.Purchaser;
import Model.User.Request;

import View.ViewSignUp;
import View.ViewLogIn;

import java.util.ArrayList;
import java.util.regex.*;
public class AccountController {
    private static ArrayList<Purchaser> purchasers = new ArrayList<>();
    private Account account;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    public void signUpPurchaser(){
        ViewSignUp viewSignUp = new ViewSignUp();
        viewSignUp.visitSignUpPage();
        while (checkUsername(viewSignUp.getUserName())){
            viewSignUp.errorUserName();
        }
        while (checkPassword(viewSignUp.getPassword())){
            viewSignUp.errorPassword();
        }
        while (checkPhoneNumber(viewSignUp.getPhoneNumber())){
            viewSignUp.errorPhoneNumber();
        }
        while (!checkEmail(viewSignUp.getEmail())){
            viewSignUp.errorEmail();
        }
        Purchaser purchaser = new Purchaser(username,email,phoneNumber,password);
        Request request = new Request("signUp",purchaser);
        Admin admin = Admin.getAdmin();
        admin.getRequests().add(request);
        viewSignUp.sendRequest();
    }
    public void logInPurchaser(){
        ViewLogIn viewLogIn = new ViewLogIn();
        viewLogIn.visitLogInPage();
        while (!checkLogIn(viewLogIn.getUserName(),viewLogIn.getPassword())){
            viewLogIn.errorUserNameOrPassword();
        }
        if(account instanceof Purchaser){
            PurchaserController purchaserController = new PurchaserController();
            purchaserController.purchaserController((Purchaser) account);
        }
        else if(account instanceof Admin){
            AdminController adminController = new AdminController();
            adminController.adminController();
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
        if (!truePasswordAndUserName){
            Admin admin = Admin.getAdmin();
            if(admin.getUserName().equals(username) && admin.getPassword().equals(password)){
                truePasswordAndUserName=true;
                this.account=admin;
            }
        }
        return truePasswordAndUserName;
    }
    boolean checkUsername(String username){
        boolean duplicateUsername=false;
        for (Purchaser purchaser: purchasers){
            if (purchaser.getUserName().equals(username)) {
                duplicateUsername = true;
                break;
            }
        }
        if (!duplicateUsername){
            this.username=username;
        }
        return duplicateUsername;
    }
    boolean checkPassword(String password){
        boolean truePassword=false;
        Pattern pattern =Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher =pattern.matcher(password);
        boolean found = matcher.find();
        if (found){
            this.password=password;
            truePassword=true;
        }
        return !truePassword;
    }
    boolean checkPhoneNumber(String phoneNumber){
        boolean truePhoneNumber=false;
        Pattern pattern =Pattern.compile("^(09)+\\d{9}$");
        Matcher matcher =pattern.matcher(phoneNumber);
        boolean found = matcher.find();
        if (found){
            this.phoneNumber=phoneNumber;
            truePhoneNumber=true;
        }
        return !truePhoneNumber;
    }
    boolean checkEmail(String email){
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
        AccountController.purchasers = purchasers;
    }
}
