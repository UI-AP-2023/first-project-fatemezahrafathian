package Model.Exception;

public class AddScoreException extends Exception{
    public AddScoreException(){
        super("you must buy product first");
    }
}
