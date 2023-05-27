package Controller;

import Model.Product.*;
import Model.User.Admin;
import Model.User.Comment;
import Model.User.Purchaser;
import Model.User.Request;
import View.ViewProducts;

import java.util.ArrayList;

public class ProductController {
    private ViewProducts viewProducts = new ViewProducts();
    private Admin admin = Admin.getAdmin();
    public void productsController(){
        int choice=1;
        while (choice!=0){
            viewProducts.choice1();
            choice=viewProducts.enterChoice();
            switch (choice) {
                case 1 -> viewProducts.visitPage(filter(admin.getProducts()));
                case 2 -> viewProducts.visitPage(search(viewProducts.getName()));
                case 3 -> visitProducts();
                default -> {
                    if(choice!=0)
                        viewProducts.error();
                }
            }
        }
    }
    public void visitProducts(){
        int numberOfShowProduct=0;
        Admin admin=Admin.getAdmin();
        numberOfShowProduct=showPage(numberOfShowProduct);
        int choice0=1;
        while (choice0!=0){
            choice0=viewProducts.enterChoice();
            if(choice0==1 && numberOfShowProduct<admin.getProducts().size()){
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice0==2 && numberOfShowProduct>5){
                numberOfShowProduct-=10;
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice0==3){
                select(viewProducts.getName());
            }
            else if(choice0!=0){
                viewProducts.error();
            }
        }

    }
    public void select(String productId){
        boolean exist=false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                exist=true;
                int choice2=1;
                while (choice2!=0){
                    viewProducts.choice2();
                    choice2= viewProducts.enterChoice();
                    switch (choice2){
                        case 1-> viewProducts.visitProduct(product);
                        case 2-> viewProducts.visitProductComment(product);
                        case 3->{
                            Comment comment = new Comment(null,product,viewProducts.getComment(),false);
                            Request request = new Request("comment",comment);
                            admin.getRequests().add(request);
                        }
                        default -> {
                            if (choice2!=0)
                                viewProducts.error();
                        }
                    }
                }
            }
        }
        if (!exist) viewProducts.error();
    }
    public int showPage(int numberOfShowProduct){
        int showProduct=numberOfShowProduct;
        boolean show=false;
        Admin admin = Admin.getAdmin();
        ArrayList<Product> products = new ArrayList<>();
        if (admin.getProducts().size() == 0) return 0;
        for (Product product : admin.getProducts().subList(numberOfShowProduct,admin.getProducts().size())){
            products.add(product);
            showProduct++;
            if(showProduct%5==0){
                show=true;
                viewProducts.visitPage(products);
                products.clear();
                if (showProduct<admin.getProducts().size()){
                    viewProducts.nextPage();
                }
                if (showProduct>5){
                    viewProducts.previousPage();
                }
                viewProducts.choice();
                break;
            }
        }
        if(!show){
            viewProducts.visitPage(products);
            products.clear();
            if (showProduct<admin.getProducts().size()){
                viewProducts.nextPage();
            }
            if (showProduct>5){
                viewProducts.previousPage();
            }
            viewProducts.choice();
        }
        return showProduct;
    }
    public void visitProducts(Purchaser purchaser){
        int numberOfShowProduct=0;
        Admin admin=Admin.getAdmin();
        numberOfShowProduct=showPage(numberOfShowProduct);
        int choice0=1;
        while (choice0!=0){
            choice0=viewProducts.enterChoice();
            if(choice0==1 && numberOfShowProduct<admin.getProducts().size()){
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice0==2 && numberOfShowProduct>5){
                numberOfShowProduct-=10;
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice0==3){
                select(viewProducts.getName(),purchaser);
            }
            else if(choice0!=0){
                viewProducts.error();
            }
        }

    }
    public void select(String productId,Purchaser purchaser){
        boolean exist=false;
        for (Product product : admin.getProducts()){
            if(product.getProductID().equals(productId)){
                exist=true;
                int choice2=1;
                while (choice2!=0){
                    viewProducts.choice3();
                    choice2= viewProducts.enterChoice();
                    switch (choice2){
                        case 1-> viewProducts.visitProduct(product);
                        case 2-> viewProducts.visitProductComment(product);
                        case 3->{
                            Comment comment = new Comment(null,product,viewProducts.getComment(),false);
                            Request request = new Request("comment",comment);
                            admin.getRequests().add(request);
                        }
                        case 4->{
                            PurchaserController purchaserController = new PurchaserController();
                            //purchaserController.addProductToCart(product,purchaser);
                        }
                        default -> {
                            if (choice2!=0)
                                viewProducts.error();
                        }
                    }
                }
            }
        }
        if (!exist) viewProducts.error();
    }
    public ArrayList<Product> search(String productName){
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : admin.getProducts()){
            if (product.getName().equals(productName)){
                products.add(product);
            }
        }
        return products;
    }
    public ArrayList<Product> filter(ArrayList<Product> products){
        int choice00=1;
        while (choice00!=0){
            viewProducts.filterPage();
            choice00=viewProducts.enterChoice();
            switch (choice00){
                case 1 -> {
                    return filterCategory(products,viewProducts.getProductCategory());
                }
                case 2 -> {
                    return filterInventoryStatus(products,viewProducts.getInventoryStatus());
                }
                case 3 -> {
                    return filterPrice(products, viewProducts.getPrice(), viewProducts.getPrice());
                }
                case 4 -> {
                    return filterColor(products,viewProducts.getName());
                }
                case 5 -> {
                    return filterCompanyName(products,viewProducts.getName());
                }
                case 6 -> {
                    return filterDimension(products,viewProducts.getName());
                }
                case 7 -> {
                    return filterVersion(products,viewProducts.getName());
                }
                case 8 -> {
                    return filterPaperType(products,viewProducts.getName());
                }
            }
        }
        return null;
    }
    public ArrayList<Product> filterCategory(ArrayList<Product> products,ProductCategory productCategory){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product.getProductCategory().equals(productCategory)){
                newProducts.add(product);
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterInventoryStatus(ArrayList<Product> products,int inventoryStatus){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product.getInventoryStatus()>=inventoryStatus){
                newProducts.add(product);
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterPrice(ArrayList<Product> products,double minPrice,double maxPrice){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (minPrice <= product.getPrice() && product.getPrice()<=maxPrice){
                newProducts.add(product);
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterColor(ArrayList<Product> products,String color){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof Pen){
                if (((Pen) product).getColor().equals(color)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterCompanyName(ArrayList<Product> products,String companyName){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof Vehicle){
                if (((Vehicle) product).getCompanyName().equals(companyName)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterDimension(ArrayList<Product> products,String dimension){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof DigitalGoods){
                if (((DigitalGoods) product).getDimensions().equals(dimension)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterVersion(ArrayList<Product> products,String version){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof FlashMemory){
                if (((FlashMemory) product).getVersion().equals(version)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterPaperType(ArrayList<Product> products,String paperType){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof NoteBook){
                if (((NoteBook) product).getPaperType().equals(paperType)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
}
