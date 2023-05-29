package Model.Exception;

public class InsufficientCredit extends InvalidPurchase {
    public InsufficientCredit(){
        super("Insufficient credit");
    }

}
