package Controller;

import java.util.Random;

public class DiscountController {
    public String makeDiscountCode(){
        Random random = new Random();
        return ((char)random.nextInt(65, 26)) +
                String.valueOf(random.nextInt(99)) +
                ((char)random.nextInt(65, 26));
    }
}
