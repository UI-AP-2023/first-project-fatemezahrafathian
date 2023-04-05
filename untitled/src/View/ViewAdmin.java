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
    public String getDate(){scanner.next();
        return scanner.next();}
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
        String helpList = """
                add: enter add to add Product then enter\s
                remove: enter remove to remove product then enter productId\s
                edit: enter edit to edit  purchaser information\s
                visitProducts: enter visitProducts to visit Products\s
                visitRequests: enter visitRequests to visit Requests\s
                acceptRequest: enter acceptRequest to accept Request\s
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
        System.out.println(request.getRequestId());
        System.out.println("\n\n");
    }
    public void successfulAdd(){
        System.out.println("add was successful");
    }
}
