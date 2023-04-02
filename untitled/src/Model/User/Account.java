package Model.User;
import java.text.ParsePosition;
import java.util.regex.*;
public abstract class Account {
    public Account(String userName, String email, String phoneNumber, String password) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    private final String userName;
    private String email;
    private String phoneNumber;
    private String password;
    //************************************************************************
    public String getUserName() {
        return this.userName;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
