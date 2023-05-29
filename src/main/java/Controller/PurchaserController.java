package Controller;

import Model.Exception.*;
import Model.Product.Product;
import Model.User.*;
import View.ViewPurchaser;

import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaserController {
    /*public void purchaserController(Purchaser purchaser){
        ProductController productController = new ProductController();
        int choice= 1 ;
        while (choice!=0){
            viewPurchaser.choice();
            choice=viewPurchaser.enterChoice();
            if (choice == 1){
//                try {
//                    //editInformation(purchaser);
//                } catch (InvalidEmail e) {
//                    throw new RuntimeException(e);
//                } catch (InvalidPhone e) {
//                    e.getMessage();
//                }
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
            else if(choice==10){
                visitDiscountCode(purchaser);
            }
            else if (choice!=0)viewPurchaser.error();
        }
    }*/


//    public void visitHistory(Purchaser purchaser){
//        for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
//            System.out.println(purchaseInvoice.toString());
//        }
//    }

//    public void visitDiscountCode(Purchaser purchaser){
//        viewPurchaser.discountCode(purchaser);
//    }

    public void addProductToCart(Product product,Purchaser purchaser){
        purchaser.getCart().getCart().add(product);
        purchaser.getCart().setPrice(purchaser.getCart().getPrice()+product.getPrice());
    }
    public void addScore(Purchaser purchaser,Product product0,double score0) throws AddScoreException {
        boolean found=false;
        for (PurchaseInvoice purchaseInvoice: purchaser.getPurchaseHistory()){
            for (Product product: purchaseInvoice.getListOfPurchasedGoods().keySet()){
                if (product.equals(product0)){
                    found=true;
                    Score score = new Score(purchaser,product,(int) score0);
                    score.getProduct().setAverageScoreOfBuyers((score.getScore()+score.getProduct().getNumberOfPurchaserThatAddScore()*score.getProduct().getAverageScoreOfBuyers())/(score.getProduct().getNumberOfPurchaserThatAddScore()+1));
                    score.getProduct().setNumberOfPurchaserThatAddScore((score.getProduct().getNumberOfPurchaserThatAddScore()+1));
                }
            }
        }
        if (!found)
            throw new AddScoreException();
    }
    public void addComment(Product selectedProduct,Purchaser purchaser,String comment0){
    boolean theCommenterBoughtProduct=false;
    Admin admin = Admin.getAdmin();
    for (Product product : admin.getProducts()){
        if (product.equals(selectedProduct)){
            for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
                for (Product product1 :purchaseInvoice.getListOfPurchasedGoods().keySet()){
                    if (product.equals(product1)) {
                        theCommenterBoughtProduct = true;
                        break;
                    }
                }
            }
            Comment comment;
            if (theCommenterBoughtProduct){
                comment = new Comment(purchaser,product,comment0 , true);
            }
            else {
                comment = new Comment(purchaser,product,comment0, false);
            }
            Request request = new Request("comment",comment);
            admin.getRequests().add(request);
        }
    }
}
    public void buy(Purchaser purchaser) throws InsufficientCredit, ProductOutOfStock {
    PurchaseInvoice purchaseInvoice=new PurchaseInvoice(LocalDate.now());
    if(purchaser.getAccountCredentials()>= purchaser.getCart().getPrice()){

    }
    else {
        throw new InsufficientCredit();
    }
    for (Product product:purchaser.getCart().getCart()){
        if(!(product.getInventoryStatus()>=1)){
            throw new ProductOutOfStock();
        }
        if (purchaseInvoice.getListOfPurchasedGoods().containsKey(product)){
            Integer inventory=purchaseInvoice.getListOfPurchasedGoods().get(product);
            purchaseInvoice.getListOfPurchasedGoods().remove(product);
            purchaseInvoice.getListOfPurchasedGoods().put(product,inventory+1);
        }
        else {
            purchaseInvoice.getListOfPurchasedGoods().put(product,1);
        }
    }
    for (Product product:purchaseInvoice.getListOfPurchasedGoods().keySet()){
        Admin admin1= Admin.getAdmin();
        for (Product product0:admin1.getProducts()){
            if (product.equals(product0)){
                product.setInventoryStatus(product.getInventoryStatus()-purchaseInvoice.getListOfPurchasedGoods().get(product));
            }
        }

    }
    purchaseInvoice.setAmountPaid(purchaser.getCart().getPrice());
    purchaser.getPurchaseHistory().add(purchaseInvoice);
    purchaser.setAccountCredentials(purchaser.getAccountCredentials()-purchaser.getCart().getPrice());
}
    public void topOfUserAccountCredit(Purchaser purchaser,String numberCart,String password,String cvv2,double amount) throws InvalidNumberOfCart, InvalidPassword, InvalidCcv2 {
        checkNumberOfCart(numberCart);
        checkPasswordCart(password);
        checkCvv2(cvv2);
        Request request = new Request("accountCredentials",purchaser,amount);
        Admin admin = Admin.getAdmin();
        admin.getRequests().add(request);
    }
    public void checkNumberOfCart( String numberCart) throws InvalidNumberOfCart {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(numberCart);
        if (!matcher.find()){
            throw new InvalidNumberOfCart();
        }
    }
    public void checkPasswordCart(String password) throws InvalidPassword {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()){
            throw new InvalidPassword();
        }
    }
    public void checkCvv2(String cvv2) throws InvalidCcv2 {
        Pattern pattern = Pattern.compile("^\\d{3,4}$");
        Matcher matcher = pattern.matcher(cvv2);
        if (!matcher.find()){
            throw new InvalidCcv2();
        }
    }
    public void editInformation(Purchaser purchaser,String newPassword,String newEmail,String newPhoneNumber) throws InvalidEmail, InvalidPhone, InvalidPassword {
        AccountController accountController = new AccountController();
        accountController.checkPassword(newPassword);
        accountController.checkPhoneNumber(newPhoneNumber);
        accountController.checkEmail(newEmail);
        purchaser.setPassword(newPassword);
        purchaser.setEmail(newEmail);
        purchaser.setPhoneNumber(newPhoneNumber);
    }
    public void useDiscountCode(Purchaser purchaser,String disCountCode0)throws DiscountException{
        boolean found=false;
        for (DiscountCode discountCode : purchaser.getDiscountCodes()) {
            if (disCountCode0.equals(discountCode.getDiscountCode())) {
                if (discountCode.getCapacity()>0 && discountCode.getDiscountCredit().isAfter(LocalDate.now())){
                    purchaser.getCart().setPrice(purchaser.getCart().getPrice()-(purchaser.getCart().getPrice()*discountCode.getDiscountPercent()/100));
                    discountCode.setCapacity(discountCode.getCapacity()-1);
                    found=true;
                }
            }
        }
        if (!found){
            throw new DiscountException();
        }
    }
}