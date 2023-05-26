package Model.Exception;

public class InvalidPassword extends InvalidInput {
    public InvalidPassword() {
        super("password is invalid");
    }
}
