package Model.Exception;

public class InvalidUsername extends InvalidInput {
    public InvalidUsername() {
        super("username is invalid");
    }
}
