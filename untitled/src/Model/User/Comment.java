package Model.User;

import Model.Product.Product;

public class Comment {
    public Comment(Purchaser commentingUser, Product product, String commentText,boolean theCommenterBoughtTheProduct){
        this.commentingUser=commentingUser;
        this.product=product;
        this.commentText=commentText;
        this.theCommenterBoughtTheProduct=theCommenterBoughtTheProduct;
    }
    Purchaser commentingUser;
    Product product;
    String commentText;
    boolean commentStatus;
    boolean theCommenterBoughtTheProduct;
    public String toString(){
        if (theCommenterBoughtTheProduct)
            return "The Commenter Bought The Product    "+commentingUser.getUserName()+"     "+commentText;
        else return "The commenter did not buy the product"+"     "+commentText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
