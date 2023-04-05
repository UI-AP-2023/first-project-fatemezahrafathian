package View;
import Controller.AccountController;

import Model.Product.BikeType;
import Model.Product.PencilType;
import Model.User.Admin;
import Model.User.Purchaser;
import Model.User.Request;

import java.util.Scanner;
public class ViewAdmin {
    Scanner scanner = new Scanner(System.in);
    public void viewAdmin(){
        System.out.println("Admin...!");
        System.out.println("-----------------------------------------");
    }
    public String getOrder(){
        return scanner.next();
    }
    public String getProduct(){
        return scanner.next();
    }
    public String getName(){
        return scanner.next();
    }
    public double getPrice(){
        return scanner.nextDouble();
    }
    public int getInventoryStatus(){
        return scanner.nextInt();
    }
    public boolean getBoolean(){return scanner.nextBoolean();}
    public String getDate(){return scanner.next();}
    public PencilType getPencilType(){
        String pencilType = scanner.next();
        if(pencilType.equals(PencilType.B.name())){
            return PencilType.B;
        }
        else if(pencilType.equals(PencilType.H2.name())){
            return PencilType.H2;
        }
        else if(pencilType.equals(PencilType.H.name())){
            return PencilType.H;
        }
        else if(pencilType.equals(PencilType.HB.name())){
            return PencilType.HB;
        }
        else if(pencilType.equals(PencilType.F.name())){
            return PencilType.F;
        }
        return null;
    }
    public BikeType getBikeType(){
        String bikeType = scanner.next();
        if(bikeType.equals(BikeType.HYBRID.name())){
            return BikeType.HYBRID;
        }
        else if(bikeType.equals(BikeType.ROAD.name())){
            return BikeType.ROAD;
        }
        else if(bikeType.equals(BikeType.MOUNTAIN.name())){
            return BikeType.MOUNTAIN;
        }
        else if(bikeType.equals(BikeType.URBAN.name())){
            return BikeType.URBAN;
        }
        return null;
    }
    public void help(){
        StringBuilder helpList = new StringBuilder();
        helpList.append("add: enter add to add Product then enter \n");
        helpList.append("remove: enter remove to remove product then enter productId \n");
        helpList.append("edit: enter edit to edit  purchaser information \n");
        helpList.append("visitProducts: enter visitProducts to visit Products \n");
        helpList.append("visitRequests: enter visitRequests to visit Requests \n");
        helpList.append("acceptRequest: enter acceptRequest to accept Request \n");
        helpList.append("exit: enter exit to exit Product ");
        System.out.println(helpList);
    }
    public void error(){
        System.out.println("The entered order is invalid...");
    }
    public void visitUsers(Purchaser purchaser){
        System.out.println(purchaser.getUserName());
    }
    public void visitRequest(Request request){
        System.out.println(request.getRequestType());
        System.out.println(request.getRequestSender());
        System.out.println(request.getRequestId());
        System.out.println("\n\n");
    }
}
