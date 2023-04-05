package Controller;

import Model.Product.*;
import Model.User.Admin;
import Model.User.Purchaser;
import Model.User.Request;
import View.ViewAdmin;

public class AdminController {
    public void adminController(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.viewAdmin();
        String order =viewAdmin.getOrder();
        while (!order.equals("exit"))   {
            if (order.equals("help")){
                viewAdmin.help();
            }
            else if (order.equals("add")){
                addProduct();
            }
            else if (order.equals("remove")){
                removeProduct();
            }
            else if (order.equals("edit")){
                editProduct();
            }
            else if (order.equals("visitRequests")){
                visitRequests();
            }
            else if (order.equals("acceptRequest")){
                accept(viewAdmin.getName(), viewAdmin.getName());
            }
            else if (order.equals("visitUsers")){
                visitUsers();
            }
            else{
                viewAdmin.error();
            }
            order =viewAdmin.getOrder();
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
    ///continue--------------------------------------------------
    public void accept(String typeOfRequest,String requestId){
        Admin admin = Admin.getAdmin();
        for(Request request : admin.getRequests()){
            if(request.getRequestId()==requestId){
                request.setAccepted(true);
                if (typeOfRequest.equals("signUp")){
                    AccountController accountController = new AccountController();
                    accountController.getPurchasers().add(request.getRequestSender());
                }
                if (typeOfRequest.equals("comment")){

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
    //-------------------------------------------------------------
    public  void  addProduct(){
        Admin admin = Admin.getAdmin();
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.viewAdmin();
        String product =viewAdmin.getProduct();
        if (product.equals("Bike")){
            Bike bike = new Bike(ProductCategory.VEHICLES, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getName(),viewAdmin.getBikeType());
            admin.getProducts().add(bike);
        }
        else if (product.equals("Car")){
            Car car = new Car(ProductCategory.VEHICLES, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getPrice(), viewAdmin.getBoolean());
            admin.getProducts().add(car);
        }
        else if (product.equals("Edible")){
            Edible edible = new Edible(ProductCategory.EDIBLE, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getDate(), viewAdmin.getDate());
            admin.getProducts().add(edible);
        }
        else if (product.equals("NoteBook")){
            NoteBook noteBook = new NoteBook(ProductCategory.STATIONERY, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getName());
            admin.getProducts().add(noteBook);
        }
        else if (product.equals("Pen")){
            Pen pen = new Pen(ProductCategory.STATIONERY, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getName(), viewAdmin.getName());
            admin.getProducts().add(pen);
        }
        else if (product.equals("Pencil")){
            Pencil pencil = new Pencil(ProductCategory.STATIONERY, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getName(),viewAdmin.getPencilType());
            admin.getProducts().add(pencil);
        }
        else if (product.equals("PersonalComputer")){
            PersonalComputer personalComputer = new PersonalComputer(ProductCategory.STATIONERY, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getName(), viewAdmin.getInventoryStatus());
            admin.getProducts().add(personalComputer);
        }
        else if (product.equals("SSD")){
            SSD ssd = new SSD(ProductCategory.STATIONERY, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getPrice());
            admin.getProducts().add(ssd);
        }
        else if (product.equals("FlashMemory")){
            FlashMemory flashMemory = new FlashMemory(ProductCategory.DIGITAL_GOODS, viewAdmin.getName(),viewAdmin.getPrice(),viewAdmin.getInventoryStatus(), viewAdmin.getPrice(), viewAdmin.getName(), viewAdmin.getInventoryStatus(), viewAdmin.getName());
            admin.getProducts().add(flashMemory);
        }
        else{
            viewAdmin.error();
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
                if (field.equals("name")){
                    product.setName(viewAdmin.getName());
                }
                else if (field.equals("price")){
                    product.setPrice(viewAdmin.getPrice());
                }
                else if (field.equals("inventoryStatus")){
                    product.setInventoryStatus(viewAdmin.getInventoryStatus());
                }
                else viewAdmin.error();
            }
        }
        if (!found){
            viewAdmin.error();
        }
    }


}
