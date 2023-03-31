package Controller;

import java.util.regex.*;

public class AccountController {
    String phoneNumber = "78945612";
    Pattern pattern =Pattern.compile("^(09)+\\d{9}$");
    Matcher matcher =pattern.matcher(phoneNumber);
    boolean found = matcher.find();
}
