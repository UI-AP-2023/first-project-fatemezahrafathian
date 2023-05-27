package Controller;

import Model.Exception.*;
import Model.Exception.InvalidEmail;
import Model.Exception.InvalidPhone;
import Model.User.*;
import com.example.demo1.HomeController;

import java.util.ArrayList;
import java.util.regex.*;
public class AccountController {
    public AccountController(){
        Purchaser purchaser = new Purchaser("fathian","asd@gmail.com","09132547896","Fathian83");
        DiscountCode discountCode = new DiscountCode(20,"12/12/1212",2);
        purchaser.getDiscountCodes().add(discountCode);
        DiscountCode discountCode1 = new DiscountCode(20,"12/12/1212",2);
        purchaser.getDiscountCodes().add(discountCode1);
        purchasers.add(purchaser);
    }
    private static ArrayList<Purchaser> purchasers = new ArrayList<>();
    private static Account account;
    //*********************************************************************************************
    public void logIn(String username, String password) throws LoginPurchaser, LoginAdmin, LoginException {
        for (Purchaser purchaser:purchasers){
            if(purchaser.getUserName().equals(username) && purchaser.getPassword().equals(password)){
                account=purchaser;
                HomeController.setLogin(true);
                throw new LoginPurchaser();
            }
        }
        Admin admin = Admin.getAdmin();
        if(admin.getUserName().equals(username) && admin.getPassword().equals(password)){
            account=admin;
            throw new LoginAdmin();
        }
        else throw new LoginException();
    }
    public void signup(String username, String password, String phoneNumber, String email) throws InvalidEmail, InvalidPhone, InvalidUsername, InvalidPassword, SendRequest {
        checkUsername(username);
        checkPassword(password);
        checkPhoneNumber(phoneNumber);
        checkEmail(email);
        Purchaser purchaser = new Purchaser(username,email,phoneNumber,password);
        Request request = new Request("signUp",purchaser);
        Admin admin = Admin.getAdmin();
        admin.getRequests().add(request);
        throw new SendRequest();
    }
    void checkUsername(String username) throws InvalidUsername {
        boolean duplicateUsername=false;
        for (Purchaser purchaser: purchasers){
            if (purchaser.getUserName().equals(username)) {
                duplicateUsername = true;
                break;
            }
        }
        if (duplicateUsername){
            throw new InvalidUsername();
        }
    }
    void checkPassword(String password) throws InvalidPassword {
        Pattern pattern =Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher =pattern.matcher(password);
        boolean found = matcher.find();
        if (!found){
            throw new InvalidPassword();
        }
    }
    void checkPhoneNumber(String phoneNumber) throws InvalidPhone {
        Pattern pattern =Pattern.compile("^(09)+\\d{9}$");
        Matcher matcher =pattern.matcher(phoneNumber);
        boolean found = matcher.find();
        if (!found){
            throw new InvalidPhone();
        }
    }
    void checkEmail(String email) throws InvalidEmail {
        Pattern pattern =Pattern.compile("^\\w+@(gmail|yahoo)\\.com$");
        Matcher matcher =pattern.matcher(email);
        boolean found = matcher.find();
        if (!found){
            throw new InvalidEmail();
        }
    }
    //******************************************************************************************
    public ArrayList<Purchaser> getPurchasers() {
        return purchasers;
    }
    public void setPurchasers(ArrayList<Purchaser> purchasers) {
        AccountController.purchasers = purchasers;
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        AccountController.account = account;
    }
}
