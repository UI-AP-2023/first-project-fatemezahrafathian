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
    String getUserName() {
        return this.userName;
    }
    String getEmail() {
        return this.email;
    }
    void setEmail(String email) {
        this.email = email;
    }
    String getPhoneNumber() {
        return this.phoneNumber;
    }
    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    String getPassword() {
        return this.password;
    }
    void setPassword(String password) {
        this.password = password;
    }
}
