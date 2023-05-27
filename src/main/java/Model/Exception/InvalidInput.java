package Model.Exception;

abstract public class InvalidInput extends Exception{
    public InvalidInput(String massage){
        super("Invalid Input-"+massage);
    }

}
