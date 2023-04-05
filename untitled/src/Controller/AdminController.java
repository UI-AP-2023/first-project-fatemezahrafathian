package Controller;

import Model.Product.*;
import Model.User.Admin;
import Model.User.Purchaser;
import Model.User.Request;

import View.ViewAdmin;

public class AdminController {
    public void adminController(){
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.viewAdmin();
        String order =viewAdmin.getOrder();
        while (!order.equals("exit"))   {
            switch (order) {
                case "help" -> viewAdmin.help();
                case "add" -> addProduct(viewAdmin.getProduct());
                case "remove" -> removeProduct();
                case "edit" -> editProduct();
                case "visitRequests" -> visitRequests();
                case "acceptRequest" -> accept(viewAdmin.getName(), viewAdmin.getName());
                case "visitUsers" -> visitUsers();
                default -> viewAdmin.error();
            }
            order =viewAdmin.getOrder();
        }
    }
    public  void  addProduct(String product ){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        switch (product) {
            case "Bike" -> {
                Bike bike = new Bike(ProductCategory.VEHICLES, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getBikeType());
                admin.getProducts().add(bike);
                viewAdmin.successfulAdd();
            }
            case "Car" -> {
                Car car = new Car(ProductCategory.VEHICLES, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getBoolean());
                admin.getProducts().add(car);
                viewAdmin.successfulAdd();
            }
            case "Edible" -> {
                Edible edible = new Edible(ProductCategory.EDIBLE, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getDate(), viewAdmin.getDate());
                admin.getProducts().add(edible);
                viewAdmin.successfulAdd();
            }
            case "NoteBook" -> {
                NoteBook noteBook = new NoteBook(ProductCategory.STATIONERY, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getName());
                admin.getProducts().add(noteBook);
                viewAdmin.successfulAdd();
            }
            case "Pen" -> {
                Pen pen = new Pen(ProductCategory.STATIONERY, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getName());
                admin.getProducts().add(pen);
                viewAdmin.successfulAdd();
            }
            case "Pencil" -> {
                Pencil pencil = new Pencil(ProductCategory.STATIONERY, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getPencilType());
                admin.getProducts().add(pencil);
                viewAdmin.successfulAdd();
            }
            case "PersonalComputer" -> {
                PersonalComputer personalComputer = new PersonalComputer(ProductCategory.STATIONERY, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getName(), viewAdmin.getInventoryStatus());
                admin.getProducts().add(personalComputer);
                viewAdmin.successfulAdd();
            }
            case "SSD" -> {
                SSD ssd = new SSD(ProductCategory.STATIONERY, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getPrice());
                admin.getProducts().add(ssd);
                viewAdmin.successfulAdd();
            }
            case "FlashMemory" -> {
                FlashMemory flashMemory = new FlashMemory(ProductCategory.DIGITAL_GOODS, viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getName());
                admin.getProducts().add(flashMemory);
                viewAdmin.successfulAdd();
            }
            default -> {
                viewAdmin.error();}
        }
    }
    public  void  removeProduct(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.viewAdmin();
        String productId =viewAdmin.getProduct();
        boolean found = false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                admin.getProducts().remove(product);
                found=true;
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
    public void accept(String typeOfRequest,String requestId){
        Admin admin = Admin.getAdmin();
        for(Request request : admin.getRequests()){
            if(request.getRequestId().equals(requestId)){
                request.setAccepted(true);
                if (typeOfRequest.equals("signUp")){
                    AccountController accountController = new AccountController();
                    accountController.getPurchasers().add(request.getRequestSender());
                }
                if (typeOfRequest.equals("comment")){
                    request.getComment().getProduct().getComments().add(request.getComment());
                }
                if (typeOfRequest.equals("accountCredentials")){
                    AccountController accountController = new AccountController();
                    for (Purchaser purchaser : accountController.getPurchasers()){
                        if (purchaser.equals(request.getRequestSender())){
                            purchaser.setAccountCredentials(purchaser.getAccountCredentials()+ request.getAmount());
                        }
                    }
                }
            }
        }
    }
    public  void  editProduct(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.viewAdmin();
        String productId =viewAdmin.getProduct();
        boolean found = false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                found=true;
                String field =viewAdmin.getProduct();
                switch (field) {
                    case "name" -> product.setName(viewAdmin.getName());
                    case "price" -> product.setPrice(viewAdmin.getPrice());
                    case "inventoryStatus" -> product.setInventoryStatus(viewAdmin.getInventoryStatus());
                    default -> viewAdmin.error();
                }
            }
        }
        if (!found){
            viewAdmin.error();
        }
    }
}
