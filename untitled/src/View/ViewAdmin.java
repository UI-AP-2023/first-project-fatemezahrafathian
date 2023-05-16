package View;

import Model.Product.BikeType;
import Model.Product.PencilType;
import Model.User.Purchaser;
import Model.User.Request;

import java.util.Scanner;
public class ViewAdmin {
    Scanner scanner = new Scanner(System.in);
    public void viewAdmin(){
        System.out.println("Admin...!");
        System.out.println("-----------------------------------------");
    }
    public String command(){
       return scanner.nextLine();
    }
    public boolean getBoolean(String boolean1){
        return boolean1.equals("true");
        }
    public PencilType getPencilType(String pencilType){
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
    public BikeType getBikeType(String bikeType){
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
        String helpList = """
                add: enter add to add Product then enter   category    name     price    inventory    information of product\s
                remove: enter remove to remove product           productId\s
                edit: enter edit to edit  purchaser information         productId       field      new field\s
                visitProducts: enter visitProducts to visit Products\s
                visitRequests: enter visitRequests to visit Requests\s
                acceptRequest: enter acceptRequest to accept Request    category    requestId\s
                exit: enter exit to exit Product\s""";
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
        System.out.println("requestId"+ request.getRequestId());
        System.out.println("\n");
    }
    public void successfulAdd(){
        System.out.println("add was successful");
    }
}
