package com.example.demo1;

import Controller.AccountController;
import Controller.ProductController;
import Controller.PurchaserController;
import Model.Exception.AddScoreException;
import Model.Product.Product;
import Model.User.Admin;
import Model.User.Purchaser;
import Model.User.Score;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class Search implements Initializable {
    public static Product product;
    @FXML
    private Label lbProduct;

    @FXML
    private Button btAddScore;

    @FXML
    private Button btComment;

    @FXML
    private ListView<Product> listProducts;

    @FXML
    private ImageView exitImage;

    @FXML
    private Rectangle box;

    @FXML
    private Button btExit;
    @FXML
    private Button btShowComment;
    @FXML
    private Button btAddProductToCart;
    @FXML
    private Slider Score;
    @FXML
    void btAddProductToCart(MouseEvent event){
        product=listProducts.getSelectionModel().getSelectedItem();
        if(HomeController.isLogin()){
            PurchaserController purchaserController = new PurchaserController();
            purchaserController.addProductToCart(product,(Purchaser) AccountController.getAccount());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you must login first");
            alert.show();
        }
    }
    @FXML
    void btAddScore(MouseEvent event) {
        product=listProducts.getSelectionModel().getSelectedItem();
        if(HomeController.isLogin()){
            PurchaserController purchaserController = new PurchaserController();
            try {
                purchaserController.addScore((Purchaser) AccountController.getAccount(),product,Score.getValue());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("add score is successful");
                alert.show();
            }catch (AddScoreException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.show();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you must login first");
            alert.show();
        }
    }
    @FXML
    void btComment(MouseEvent event) throws IOException {
        product=listProducts.getSelectionModel().getSelectedItem();
        try {
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("showComment.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("ShowComment");
            stage.show();
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you must select product first");
            alert.show();
        }

    }
    @FXML
    void listProducts(MouseEvent event) {
        lbProduct.setText(listProducts.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    void btExit(javafx.scene.input.MouseEvent event) throws IOException {
        HomeController.setProducts(new ArrayList<>());
        listProducts.getItems().clear();
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }

    @FXML
    void btAddComment(MouseEvent event) throws IOException {
        if(HomeController.isLogin()){
            product=listProducts.getSelectionModel().getSelectedItem();
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addComment.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,450,230);
            stage.setScene(scene);
            stage.setTitle("AddComment");
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you must login first");
            alert.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listProducts.getItems().addAll(HomeController.getProducts());

    }
}
