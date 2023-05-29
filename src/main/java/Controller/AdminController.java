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
    public void addProducts(){
        Admin admin1=Admin.getAdmin();
        Bike bike = new Bike(ProductCategory.VEHICLES,"bike",78.2,2,"a",BikeType.URBAN);
        Car car = new Car(ProductCategory.VEHICLES,"car",789.3,1,"fhh",78.3,true);
        Edible edible = new Edible(ProductCategory.EDIBLE,"edible",45.3,1,"kjh","jjjj");
        FlashMemory flashMemory = new FlashMemory(ProductCategory.DIGITAL_GOODS,"flash",78.6,5,8,"kjh",8,"2");
        NoteBook noteBook = new NoteBook(ProductCategory.STATIONERY,"noteBook",12.3,2,"a",50,"h");
        Pen pen = new Pen(ProductCategory.STATIONERY,"pen",41.3,3,"a","red");
        Pencil pencil = new Pencil(ProductCategory.STATIONERY,"pencil",1.2,4,"a",PencilType.B);
        PersonalComputer personalComputer = new PersonalComputer(ProductCategory.DIGITAL_GOODS,"computer",14.3,2,5,"s","d",5);
        SSD ssd = new SSD(ProductCategory.DIGITAL_GOODS,"ssd",41,1,1,"h",5,12.3,1.3);

        Bike bike1 = new Bike(ProductCategory.VEHICLES,"bike1",100,2,"a",BikeType.URBAN);
        Car car1 = new Car(ProductCategory.VEHICLES,"car1",200,1,"fhh",78.3,true);
        Edible edible1 = new Edible(ProductCategory.EDIBLE,"edible1",50,1,"kjh","jjjj");
        FlashMemory flashMemory1 = new FlashMemory(ProductCategory.DIGITAL_GOODS,"flash1",60,5,8,"kjh",8,"2");
        NoteBook noteBook1 = new NoteBook(ProductCategory.STATIONERY,"noteBook1",70,2,"a",50,"h");
        Pen pen1 = new Pen(ProductCategory.STATIONERY,"pen1",90,3,"a","red");
        Pencil pencil1 = new Pencil(ProductCategory.STATIONERY,"pencil1",41,4,"a",PencilType.B);
        PersonalComputer personalComputer1 = new PersonalComputer(ProductCategory.DIGITAL_GOODS,"computer",45,2,5,"s","d",5);
        SSD ssd1 = new SSD(ProductCategory.DIGITAL_GOODS,"ssd1",100,1,1,"h",5,12.3,1.3);

        Bike bike2 = new Bike(ProductCategory.VEHICLES,"bike",78.2,2,"a",BikeType.URBAN);
        Car car2 = new Car(ProductCategory.VEHICLES,"car",789.3,1,"fhh",78.3,true);
        Edible edible2 = new Edible(ProductCategory.EDIBLE,"edible",45.3,1,"kjh","jjjj");
        FlashMemory flashMemory2 = new FlashMemory(ProductCategory.DIGITAL_GOODS,"flash",78.6,5,8,"kjh",8,"2");
        NoteBook noteBook2 = new NoteBook(ProductCategory.STATIONERY,"noteBook",12.3,2,"a",50,"h");
        Pen pen2 = new Pen(ProductCategory.STATIONERY,"pen",41.3,3,"a","red");
        Pencil pencil2 = new Pencil(ProductCategory.STATIONERY,"pencil",1.2,4,"a",PencilType.B);
        PersonalComputer personalComputer2 = new PersonalComputer(ProductCategory.DIGITAL_GOODS,"computer",14.3,2,5,"s","d",5);
        SSD ssd2 = new SSD(ProductCategory.DIGITAL_GOODS,"ssd",41,1,1,"h",5,12.3,1.3);

        admin1.getProducts().add(edible);
        admin1.getProducts().add(car);
        admin1.getProducts().add(bike);
        admin1.getProducts().add(flashMemory);
        admin1.getProducts().add(noteBook);
        admin1.getProducts().add(pen);
        admin1.getProducts().add(pencil);
        admin1.getProducts().add(personalComputer);
        admin1.getProducts().add(ssd);

        admin1.getProducts().add(edible1);
        admin1.getProducts().add(car1);
        admin1.getProducts().add(bike1);
        admin1.getProducts().add(flashMemory1);
        admin1.getProducts().add(noteBook1);
        admin1.getProducts().add(pen1);
        admin1.getProducts().add(pencil1);
        admin1.getProducts().add(personalComputer1);
        admin1.getProducts().add(ssd1);

        admin1.getProducts().add(edible2);
        admin1.getProducts().add(car2);
        admin1.getProducts().add(bike2);
        admin1.getProducts().add(flashMemory2);
        admin1.getProducts().add(noteBook2);
        admin1.getProducts().add(pen2);
        admin1.getProducts().add(pencil2);
        admin1.getProducts().add(personalComputer2);
        admin1.getProducts().add(ssd2);
    }

}
