package Controller;

import Model.Product.*;
import Model.User.Admin;
import Model.User.Purchaser;
import View.ViewProducts;


import java.util.ArrayList;

public class productController {
    ViewProducts viewProducts = new ViewProducts();
    public void productsController(){
        int choice = 1;
        while (choice!=0){
            if (choice == 1 ){
                visitProducts();
            }
            else if (choice == 2 ){
                Admin admin = Admin.getAdmin();
                filter(admin.getProducts());
            }
            else if (choice == 3 ){
               search(viewProducts.getId());
            }
        }

    }
    public Product search(String productId){
        Admin admin = Admin.getAdmin();
        for (Product product : admin.getProducts()){
            if (product.getProductID().equals(productId)){
               return product;
            }
        }
        return null;
    }
    public ArrayList<Product> filter(ArrayList<Product> products){
        //1
        return filterCategory(products,viewProducts.getProductCategory());
        //2
        //return filterInventoryStatus(products,viewProducts.getInventoryStatus());
        //3
        //return filterPrice(products, viewProducts.getPrice(), viewProducts.getPrice());
        //4
        //5
        //6
        //7
        //8
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
            if (product instanceof Pen){
                if (((Vehicle) product).getCompanyName().equals(companyName)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public ArrayList<Product> filterPrice(ArrayList<Product> products,String dimension){
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product product : products){
            if (product instanceof Pen){
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
            if (product instanceof Pen){
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
            if (product instanceof Pen){
                if (((NoteBook) product).getPaperType().equals(paperType)){
                    newProducts.add(product);
                }
            }
        }
        return newProducts;
    }
    public void visitProducts(){
        int numberOfShowProduct=0;
        showPage(numberOfShowProduct);
        int choice=1;
        while (choice!=0){
            if(choice==1){
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice==2){
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice==3){
                numberOfShowProduct-=5;
                numberOfShowProduct=showPage(numberOfShowProduct);
            }
            else if(choice==4){
                //select
            }
            else{
                //error
            }
            choice=viewProducts.enterChoice();
        }

    }
    public void select(){

    }
    public int showPage(int numberOfShowProduct){
        Admin admin = Admin.getAdmin();
        ArrayList<Product> products = new ArrayList<>();
        boolean hasNextPage=false;
        boolean hasPreviousPage=false;
        for (Product product : admin.getProducts().subList(numberOfShowProduct,admin.getProducts().size()-1)){
            products.add(product);
            numberOfShowProduct++;
            if(numberOfShowProduct%5==0 || admin.getProducts().indexOf(product)+1 == admin.getProducts().size()){
                viewProducts.visitPage(products);
                products= new ArrayList<>();
                if (numberOfShowProduct<admin.getProducts().size()){
                    hasNextPage=true;
                }
                if (numberOfShowProduct>5){
                    hasPreviousPage=true;
                }
                break;
            }
        }
        return numberOfShowProduct;
    }
}
