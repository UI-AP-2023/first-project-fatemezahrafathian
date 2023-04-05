package Model.User;

import Model.Product.Product;

public class Comment {
    String commentingUser;
    Product product;
    String ProductID;
    String commentText;
    String commentStatus;
    boolean theCommenterBoughtTheProduct;
    public String toString(){
        return commentingUser+"     "+commentText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
