package Controller;

import Model.Product.Product;
import Model.User.*;
import View.ViewPurchaser;
import View.ViewSignUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaserController {
    ViewPurchaser viewPurchaser = new ViewPurchaser();
    public void purchaserController(Purchaser purchaser){
        int choice= 1 ;
        while (choice!=0){
            AccountController accountController = new AccountController();
            productController productController = new productController();
            Admin admin = Admin.getAdmin();
            viewPurchaser.choice();
            choice=viewPurchaser.enterChoice();
            if (choice == 1){
                purchaser.toString();
                ViewSignUp viewSignUp = new ViewSignUp();
                int choice2= 1 ;
                while (choice2!=0) {
                    viewPurchaser.choice();
                    choice2 = viewPurchaser.enterChoice();
                    if (choice2 == 1) {
                        String newPassword="";
                        while (accountController.checkPassword(newPassword)){
                            if (newPassword!="")
                                viewSignUp.errorPassword();
                            newPassword=viewSignUp.getPassword();
                        }
                        purchaser.setPassword(newPassword);

                    } else if (choice2 == 2) {
                        String newEmail="";
                        while (accountController.checkPhoneNumber(newEmail)){
                            if (newEmail!="")
                                viewSignUp.errorPhoneNumber();
                            newEmail=viewSignUp.getPhoneNumber();
                        }
                        purchaser.setEmail(newEmail);

                    } else if (choice2 == 3) {
                        String newPhoneNumber="";
                        while (accountController.checkPhoneNumber(newPhoneNumber)){
                            if (newPhoneNumber!="")
                                viewSignUp.errorPhoneNumber();
                            newPhoneNumber=viewSignUp.getPhoneNumber();
                        }
                        purchaser.setPhoneNumber(newPhoneNumber);
                    } else viewPurchaser.error();
                }
            }
            else if(choice==2){
                productController.visitProducts();
            }
            else if(choice==3){
                productController.filter(admin.getProducts());
            }
            else if(choice==4){
                //buyProduct(product,purchaser);
            }
            else if(choice==5){
                visitHistory(purchaser);
            }
            else if(choice==6){
                Comment comment = new Comment();
                addComment(comment);
            }
            else if(choice==7){
                Score score = new Score();
                addScore(score);
            }
            else if(choice==8){
                topOfUserAccountCredit(purchaser);
            }
            else if(choice==9){
                viewPurchaser.visitCart(purchaser);
            }
            else viewPurchaser.error();
        }
    }
    public void buyProduct(Product product,Purchaser purchaser){
        viewPurchaser.visitCart(purchaser);
        int numberOfProduct=0;
        for (Product product1:purchaser.getCart()){
            numberOfProduct++;
        }
        if(purchaser.getAccountCredentials()>= product.getPrice()){
            purchaser.setAccountCredentials(purchaser.getAccountCredentials()- product.getPrice());
            purchaser.getCart().remove(product);
            product.setInventoryStatus(product.getInventoryStatus()-numberOfProduct);
        }
    }
    public void addProductToCart(Product product,Purchaser purchaser){
        purchaser.getCart().add(product);
    }
    public void visitHistory(Purchaser purchaser){
        for (purchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
            purchaseInvoice.toString();
        }
    }
    public void addComment(Comment comment){
    }
    public void addScore(Score score){
        score.getProduct().setAverageScoreOfBuyers((score.getScore()+score.getProduct().getNumberOfPurchaserThatAddScore()*score.getProduct().getAverageScoreOfBuyers())/score.getProduct().getNumberOfPurchaserThatAddScore()+1);
    }
    public void topOfUserAccountCredit(Purchaser purchaser){
        if(checkNumberOfCart(viewPurchaser.getNumberOfCart()) && checkPasswordCart(viewPurchaser.getPasswordCart()) && checkCvv2(viewPurchaser.getCvv2())){
            Request request = new Request("accountCredentials",purchaser, viewPurchaser.getAmount());
            Admin admin = Admin.getAdmin();
            admin.getRequests().add(request);
            viewPurchaser.sendRequest();
        }
        else viewPurchaser.errorPay();
    }
    public boolean checkNumberOfCart( String numberCart){
        Pattern pattern = Pattern.compile("^{12}&");
        Matcher matcher = pattern.matcher(numberCart);
        return matcher.find();
    }
    public boolean checkPasswordCart(String password){
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean checkCvv2(String cvv2){
        Pattern pattern = Pattern.compile("^{3,4}$");
        Matcher matcher = pattern.matcher(cvv2);
        return matcher.find();
    }
    public boolean checkAmount(double amount){
        if(amount>0) return true;
        else return false;
    }
}