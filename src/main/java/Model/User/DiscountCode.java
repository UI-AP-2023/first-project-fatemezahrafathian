package Model.User;

import Controller.DiscountController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DiscountCode {
    public DiscountCode(double discountPercent,String discountCredit,int  capacity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(discountCredit, formatter);
        DiscountController discountController = new DiscountController();
        this.discountPercent = discountPercent;
        this.discountCredit = date;
        this.capacity=capacity;
        discountCode=discountController.makeDiscountCode();
    }
    private double discountPercent;
    private LocalDate discountCredit;
    private int  capacity;
    private String discountCode;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDiscountCredit() {
        return discountCredit;
    }

    public void setDiscountCredit(LocalDate discountCredit) {
        this.discountCredit = discountCredit;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return discountCode ;
    }
    public String toString0() {
        return "discountPercent=           " + discountPercent +"\n\n"+
                ", discountCredit=           " + discountCredit +"\n\n"+
                ", capacity=           " + capacity +"\n\n"+
                ", discountCode=           " + discountCode +"\n\n";
    }

}
