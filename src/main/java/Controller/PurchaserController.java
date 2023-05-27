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
    private ViewPurchaser viewPurchaser = new ViewPurchaser();
    private Admin admin = Admin.getAdmin();
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
            if (purchaseInvoice.getListOfPurchasedGoods().containsKey(product.getProductID())){
                Integer inventory=purchaseInvoice.getListOfPurchasedGoods().get(product.getProductID());
                purchaseInvoice.getListOfPurchasedGoods().remove(product.getProductID());
                purchaseInvoice.getListOfPurchasedGoods().put(product.getProductID(),inventory+1);
            }
            else {
                purchaseInvoice.getListOfPurchasedGoods().put(product.getProductID(),1);
            }
        }
        for (String productId:purchaseInvoice.getListOfPurchasedGoods().keySet()){
            Admin admin1= Admin.getAdmin();
            for (Product product:admin1.getProducts()){
                if (product.getProductID().equals(productId)){
                    product.setInventoryStatus(product.getInventoryStatus()-purchaseInvoice.getListOfPurchasedGoods().get(productId));
                }
            }

        }
        purchaseInvoice.setAmountPaid(purchaser.getCart().getPrice());
        purchaser.getPurchaseHistory().add(purchaseInvoice);
        purchaser.setAccountCredentials(purchaser.getAccountCredentials()-purchaser.getCart().getPrice());
    }
//    public void addProductToCart(Product product,Purchaser purchaser){
//        purchaser.getCart().add(product);
//    }
    public void visitHistory(Purchaser purchaser){
        for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
            System.out.println(purchaseInvoice.toString());
        }
    }
//    public void addComment(String productId,Purchaser purchaser){
//        boolean theCommenterBoughtProduct=false;
//        for (Product product : admin.getProducts()){
//            if (product.getProductID().equals(productId)){
//                for (PurchaseInvoice purchaseInvoice:purchaser.getPurchaseHistory()){
//                    for (Product product1 :purchaseInvoice.getListOfPurchasedGoods()){
//                        if (product.equals(product1)) {
//                            theCommenterBoughtProduct = true;
//                            break;
//                        }
//                    }
//                }
//                Comment comment;
//                if (theCommenterBoughtProduct){
//                    comment = new Comment(purchaser,product, viewPurchaser.getComment(), true);
//                }
//                else {
//                    comment = new Comment(purchaser,product, viewPurchaser.getComment(), false);
//                }
//                Request request = new Request("comment",comment);
//                admin.getRequests().add(request);
//                viewPurchaser.sendRequest();
//            }
//        }
//    }
//    public void addScore(Purchaser purchaser,String id){
//        boolean found=false;
//        for (PurchaseInvoice purchaseInvoice: purchaser.getPurchaseHistory()){
//            for (Product product: purchaseInvoice.getListOfPurchasedGoods()){
//                if (product.getProductID().equals(id)){
//                    found=true;
//                    Score score = new Score(purchaser,product,viewPurchaser.getPoint());
//                    score.getProduct().setAverageScoreOfBuyers((score.getScore()+score.getProduct().getNumberOfPurchaserThatAddScore()*score.getProduct().getAverageScoreOfBuyers())/(score.getProduct().getNumberOfPurchaserThatAddScore()+1));
//                    score.getProduct().setAverageScoreOfBuyers((score.getProduct().getNumberOfPurchaserThatAddScore()+1));
//                }
//            }
//        }
//        if (!found)
//            viewPurchaser.error();
//    }
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
                    found=true;
                }
            }
        }
        if (!found){
            throw new DiscountException();
        }
    }
    public void visitDiscountCode(Purchaser purchaser){
        viewPurchaser.discountCode(purchaser);
    }
}