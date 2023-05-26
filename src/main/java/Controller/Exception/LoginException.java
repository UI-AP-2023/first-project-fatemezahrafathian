package Controller.Exception;

public class LoginException extends Exception{
    public LoginException(){
        super("The username or password entered is incorrect!");
    }
}
