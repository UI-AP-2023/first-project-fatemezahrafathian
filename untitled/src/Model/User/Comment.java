package Model.User;

import Model.Product.Product;

public class Comment {
    public Comment(Purchaser commentingUser, Product product, String commentText,boolean theCommenterBoughtTheProduct){
        this.commentingUser=commentingUser;
        this.product=product;
        this.commentText=commentText;
        this.theCommenterBoughtTheProduct=theCommenterBoughtTheProduct;
    }
    private Purchaser commentingUser;
    private Product product;
    private String commentText;
    private boolean theCommenterBoughtTheProduct;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public String toString(){
        if (theCommenterBoughtTheProduct)
            return "The Commenter Bought The Product    "+commentingUser.getUserName()+"     "+commentText;
        else return "The commenter did not buy the product"+"     "+commentText;
    }

}
