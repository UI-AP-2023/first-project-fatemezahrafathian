package Model.Exception;

abstract public class InvalidPurchase extends Exception {
    public InvalidPurchase(String massage){
        super("invalid purchase-"+massage);
    }
}
