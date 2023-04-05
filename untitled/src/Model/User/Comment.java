package Model.User;

public class Comment {
    String commentingUser;
    String ProductID;
    String commentText;
    String commentStatus;
    boolean theCommenterBoughtTheProduct;
    public String toString(){
        return commentingUser+"     "+commentText;
    }
}
