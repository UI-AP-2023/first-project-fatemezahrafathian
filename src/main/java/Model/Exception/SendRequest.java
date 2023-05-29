package Model.Exception;

public class SendRequest extends Exception{
    public SendRequest(){
        super("Your request has been sent to the admin.");
    }
}
