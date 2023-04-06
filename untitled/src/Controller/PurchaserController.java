package Controller;

import Model.Product.Product;
import Model.User.*;
import View.ViewPurchaser;
import View.ViewSignUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaserController {
    private ViewPurchaser viewPurchaser = new ViewPurchaser();
    private Admin admin = Admin.getAdmin();
    public void purchaserController(Purchaser purchaser){
        productController productController = new productController();
        int choice= 1 ;
        while (choice!=0){
            viewPurchaser.choice();
            choice=viewPurchaser.enterChoice();
            if (choice == 1){
                editInformation(purchaser);
            }
            else if(choice==2){
                productController.visitProducts(purchaser);
            }
            else if(choice==3){
                productController.filter(admin.getProducts());
            }
            else if(choice==4){
                viewPurchaser.visitCart(purchaser);
                String productId= viewPurchaser.getId();
                for (Product product : admin.getProducts()){
                    if (product.getProductID().equals(productId))
                        buyProduct(product,purchaser);
                }
            }
            else if(choice==5){
                visitHistory(purchaser);
            }
            else if(choice==6){
                addComment(viewPurchaser.getId(),purchaser);
            }
            else if(choice==7){
                addScore(purchaser,viewPurchaser.getId());
            }
            else if(choice==8){
                topOfUserAccountCredit(purchaser);
            }
            else if(choice==9){
                viewPurchaser.visitCart(purchaser);
            }
            else if (choice!=0)viewPurchaser.error();
        }
    }
    public void buyProduct(Product product,Purchaser purchaser){
        int numberOfProduct=0;
        for (Product product1:purchaser.getCart()){
            if (product1.equals(product))
                numberOfProduct++;
        }
        if(purchaser.getAccountCredentials()>= product.getPrice()){
            purchaser.setAccountCredentials(purchaser.getAccountCredentials()- product.getPrice());
            purchaser.getCart().remove(product);
            product.setInventoryStatus(product.getInventoryStatus()-numberOfProduct);
            PurchaseInvoice purchaseInvoice=new PurchaseInvoice(product.getProductID(),product.getPrice()*numberOfProduct);
            purchaseInvoice.getListOfPurchasedGoods().add(product);
            purchaser.getPurchaseHistory().add(purchaseInvoice);
        }
        else viewPurchaser.error();
    }
    public void addProductToCart(Product product,Purchaser purchaser){
        purchaser.getCart().add(product);
    }
    public void visitHistory(Purchaser purchaser){
        for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
            System.out.println(purchaseInvoice.toString());
        }
    }
    public void addComment(String productId,Purchaser purchaser){
        boolean theCommenterBoughtProduct=false;
        for (Product product : admin.getProducts()){
            if (product.getProductID().equals(productId)){
                for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
                    for (Product product1 :purchaseInvoice.getListOfPurchasedGoods()){
                        if (product.equals(product1)) {
                            theCommenterBoughtProduct = true;
                            break;
                        }
                    }
                }
                Comment comment;
                if (theCommenterBoughtProduct){
                    comment = new Comment(purchaser,product, viewPurchaser.getComment(), true);
                }
                else {
                    comment = new Comment(purchaser,product, viewPurchaser.getComment(), false);
                }
                Request request = new Request("comment",comment);
                admin.getRequests().add(request);
                viewPurchaser.sendRequest();
            }
        }
    }
    public void addScore(Purchaser purchaser,String id){
        boolean found=false;
        for (PurchaseInvoice purchaseInvoice: purchaser.getPurchaseHistory()){
            for (Product product: purchaseInvoice.getListOfPurchasedGoods()){
                if (product.getProductID().equals(id)){
                    found=true;
                    Score score = new Score(purchaser,product,viewPurchaser.getPoint());
                    score.getProduct().setAverageScoreOfBuyers((score.getScore()+score.getProduct().getNumberOfPurchaserThatAddScore()*score.getProduct().getAverageScoreOfBuyers())/(score.getProduct().getNumberOfPurchaserThatAddScore()+1));
                    score.getProduct().setAverageScoreOfBuyers(score.getProduct().getNumberOfPurchaserThatAddScore()+1);
                }
            }
        }
        if (!found)
            viewPurchaser.error();
    }
    public void topOfUserAccountCredit(Purchaser purchaser){
        boolean check1=checkNumberOfCart(viewPurchaser.getNumberOfCart());
        boolean check2 =checkPasswordCart(viewPurchaser.getPasswordCart());
        boolean check3=checkCvv2(viewPurchaser.getCvv2());
        if(check1&&check2 &&check3 ){
            Request request = new Request("accountCredentials",purchaser, viewPurchaser.getAmount());
            Admin admin = Admin.getAdmin();
            admin.getRequests().add(request);
            viewPurchaser.sendRequest();
        }
        else viewPurchaser.errorPay();
    }
    public boolean checkNumberOfCart( String numberCart){
        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(numberCart);
        return matcher.find();
    }
    public boolean checkPasswordCart(String password){
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean checkCvv2(String cvv2){
        Pattern pattern = Pattern.compile("^\\d{3,4}$");
        Matcher matcher = pattern.matcher(cvv2);
        return matcher.find();
    }
    public void editInformation(Purchaser purchaser){
        AccountController accountController = new AccountController();
        ViewSignUp viewSignUp = new ViewSignUp();
        viewPurchaser.information(purchaser.toString());
        int choice2= 1 ;
        while (choice2!=0) {
            viewPurchaser.editInformation();
            choice2 = viewPurchaser.enterChoice();
            if (choice2 == 1) {
                String newPassword="";
                while (accountController.checkPassword(newPassword)){
                    if (!newPassword.equals(""))
                        viewSignUp.errorPassword();
                    newPassword=viewSignUp.getPassword();
                }
                purchaser.setPassword(newPassword);

            }
            else if (choice2 == 2) {
                String newEmail="";
                while (accountController.checkEmail(newEmail)){
                    if (!newEmail.equals(""))
                        viewSignUp.errorEmail();
                    newEmail=viewSignUp.getEmail();
                }
                purchaser.setEmail(newEmail);

            }
            else if (choice2 == 3) {
                String newPhoneNumber="";
                while (accountController.checkPhoneNumber(newPhoneNumber)){
                    if (!newPhoneNumber.equals(""))
                        viewSignUp.errorPhoneNumber();
                    newPhoneNumber=viewSignUp.getPhoneNumber();
                }
                purchaser.setPhoneNumber(newPhoneNumber);
            }
            else if(choice2!=0) viewPurchaser.error();
        }
    }
}