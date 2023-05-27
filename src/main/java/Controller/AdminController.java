package Controller;

import Model.Product.*;
import Model.User.*;

import View.ViewAdmin;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class AdminController {
    private Admin admin = Admin.getAdmin();
    private ViewAdmin viewAdmin = new ViewAdmin();
    private String[] commands;
    public void adminController(String command){
        viewAdmin.viewAdmin();
        commands= command.split(" ");
        String order =commands[0];
        if (!order.equals("exit"))   {
            switch (order) {
                case "help" -> viewAdmin.help();
                case "add" -> addProduct(commands[1]);
                case "remove" -> removeProduct();
                case "edit" -> editProduct();
                case "visitRequests" -> visitRequests();
                case "acceptRequest" -> accept(commands[1]);
                case "visitUsers" -> visitUsers();
                case "assignDiscountCode"->assignDiscountCode(commands[1],commands[2],commands[3]);
                case "addDiscountProduct"->addDiscountProduct(commands[1],Double.parseDouble(commands[2]));
                case "deleteDiscountProduct"->deleteDiscountProduct(commands[1]);
                default -> viewAdmin.error();
            }
        }
    }
    public  void  addProduct(String product ){
        switch (product) {
            case "Bike" -> {
                Bike bike = new Bike(ProductCategory.VEHICLES, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5],viewAdmin.getBikeType(commands[6]));
                admin.getProducts().add(bike);
                viewAdmin.successfulAdd();
            }
            case "Car" -> {
                Car car = new Car(ProductCategory.VEHICLES, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5],Double.parseDouble(commands[6]), viewAdmin.getBoolean(commands[7]));
                admin.getProducts().add(car);
                viewAdmin.successfulAdd();
            }
            case "Edible" -> {
                Edible edible = new Edible(ProductCategory.EDIBLE, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5], commands[6]);
                admin.getProducts().add(edible);
                viewAdmin.successfulAdd();
            }
            case "NoteBook" -> {
                NoteBook noteBook = new NoteBook(ProductCategory.STATIONERY, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5],Integer.parseInt(commands[6]), commands[7]);
                admin.getProducts().add(noteBook);
                viewAdmin.successfulAdd();
            }
            case "Pen" -> {
                Pen pen = new Pen(ProductCategory.STATIONERY, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5],commands[6]);
                admin.getProducts().add(pen);
                viewAdmin.successfulAdd();
            }
            case "Pencil" -> {
                Pencil pencil = new Pencil(ProductCategory.STATIONERY, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), commands[5],viewAdmin.getPencilType(commands[6]));
                admin.getProducts().add(pencil);
                viewAdmin.successfulAdd();
            }
            case "PersonalComputer" -> {
                PersonalComputer personalComputer = new PersonalComputer(ProductCategory.STATIONERY,  commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), Double.parseDouble(commands[5]) ,commands[6], commands[7],Integer.parseInt(commands[8]));
                admin.getProducts().add(personalComputer);
                viewAdmin.successfulAdd();
            }
            case "SSD" -> {
                SSD ssd = new SSD(ProductCategory.STATIONERY, commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]), Double.parseDouble(commands[5]),commands[6],Integer.parseInt(commands[7]),Double.parseDouble(commands[8]),Double.parseDouble(commands[9]));
                admin.getProducts().add(ssd);
                viewAdmin.successfulAdd();
            }
            case "FlashMemory" -> {
                FlashMemory flashMemory = new FlashMemory(ProductCategory.DIGITAL_GOODS,  commands[2],Double.parseDouble(commands[3]), Integer.parseInt(commands[4]),Double.parseDouble(commands[5]),commands[6], Integer.parseInt(commands[7]), commands[8]);
                admin.getProducts().add(flashMemory);
                viewAdmin.successfulAdd();
            }
            default -> viewAdmin.error();
        }
    }
    public  void  removeProduct(){
        String productId =commands[1];
        Product product1=null;
        boolean found = false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                product1=product;
                found=true;
            }
        }
        if(found)
            admin.getProducts().remove(product1);
        if (!found){
            viewAdmin.error();
        }
    }
    public  void  editProduct(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        String productId =commands[1];
        boolean found = false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                found=true;
                String field =commands[2];
                switch (field) {
                    case "name" -> product.setName(commands[3]);
                    case "price" -> product.setPrice(Double.parseDouble(commands[3]));
                    case "inventoryStatus" -> product.setInventoryStatus(Integer.parseInt(commands[3]));
                    default -> viewAdmin.error();
                }
            }
        }
        if (!found){
            viewAdmin.error();
        }
    }
    public void visitRequests(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        for(Request request : admin.getRequests()){
            viewAdmin.visitRequest(request);
        }
    }
    public void visitUsers(){
        ViewAdmin viewAdmin = new ViewAdmin();
        AccountController accountController = new AccountController();
        for (Purchaser purchaser : accountController.getPurchasers()){
            viewAdmin.visitUsers(purchaser);
        }
    }
    public void accept(String requestId){

        Admin admin = Admin.getAdmin();
        for(Request request : admin.getRequests()){
            if(request.getRequestId().equals(requestId)){
                request.setAccepted(true);
                switch (request.getRequestType()) {
                    case "signUp" -> {
                        AccountController accountController = new AccountController();
                        accountController.getPurchasers().add(request.getRequestSender());
                        System.out.println("ok");
                    }
                    case "comment" -> request.getComment().getProduct().getComments().add(request.getComment());
                    case "accountCredentials" -> {
                        AccountController accountController = new AccountController();
                        for (Purchaser purchaser : accountController.getPurchasers()) {
                            if (purchaser.equals(request.getRequestSender())) {
                                purchaser.setAccountCredentials(purchaser.getAccountCredentials() + request.getAmount());
                            }
                        }
                    }
                    default -> viewAdmin.error();
                }
            }
        }
    }
    public void assignDiscountCode(String discountPercent, String discountCredit, String  capacity){
        DiscountCode discountCode = new DiscountCode(Double.parseDouble(discountPercent),discountCredit,Integer.parseInt(capacity));
        AccountController accountController = new AccountController();
        for (Purchaser purchaser: accountController.getPurchasers()){
            for (PurchaseInvoice purchaseInvoice : purchaser.getPurchaseHistory()){
                if (purchaseInvoice.getAmountPaid()>=500){
                    purchaser.getDiscountCodes().add(discountCode);
                }
            }

        }
    }
    public void addDiscountProduct(String productId,double discount){
        for (Product product: Admin.getAdmin().getProducts()){
            if (product.getProductID().equals(productId)){
                if (product instanceof DigitalGoods){
                    ((DigitalGoods) product).addDiscount(discount);
                }if (product instanceof Pen){
                    ((Pen) product).addDiscount(discount);
                }
                if (product instanceof Pencil){
                   ((Pencil) product).addDiscount(discount);
                }
            }
        }
    }
    public void deleteDiscountProduct(String productId){
        for (Product product: Admin.getAdmin().getProducts()){
            if (product.getProductID().equals(productId)){
                if (product instanceof DigitalGoods){
                    ((DigitalGoods) product).deleteDiscount();
                }if (product instanceof Pen){
                    ((Pen) product).deleteDiscount();
                }
                if (product instanceof Pencil){
                    ((Pencil) product).deleteDiscount();
                }
            }
        }
    }

}
