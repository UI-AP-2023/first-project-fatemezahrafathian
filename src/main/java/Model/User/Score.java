package Model.User;

import Model.Product.Product;

public class Score {
    public Score(Purchaser user,Product product,int score){
        this.user=user;
        this.product=product;
        this.score=score;
    }
    private Purchaser user;
    private int score;
    private Product product;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Product getProduct() {
        return product;
    }

    public Purchaser getUser() {
        return user;
    }
}
