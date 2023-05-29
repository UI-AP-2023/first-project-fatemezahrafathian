package com.example.demo1;

import Controller.AccountController;
import Controller.PurchaserController;
import Model.Exception.AddScoreException;
import Model.Product.Product;
import Model.SystemController;
import Model.User.Purchaser;
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
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class Search implements Initializable {
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
    private Button btNext;
    @FXML
    private Button btBack;
    @FXML
    void btNext(MouseEvent event){
        listProducts.getItems().clear();
        if(SystemController.getNumberOfProduct()+5<SystemController.getProducts().size()){
            listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getNumberOfProduct()+5));
        }
        else {
            listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getProducts().size()));
        }
    }
    @FXML
    void btBack(MouseEvent event){
        listProducts.getItems().clear();
        if(SystemController.getNumberOfProduct()-10>=0){
            SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()-10);
            if (SystemController.getNumberOfProduct()+5<SystemController.getProducts().size()){
                listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getNumberOfProduct()+5));
                SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+5);
            }else {
                listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getProducts().size()));
                SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+SystemController.getProducts().size());
            }
        }
        else {
            SystemController.setNumberOfProduct(0);;
            if (SystemController.getNumberOfProduct()+5<SystemController.getProducts().size()){
                listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getNumberOfProduct()+5));
                SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+5);
            }else {
                listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getProducts().size()));
                SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+SystemController.getProducts().size());
            }
        }
    }
    @FXML
    void btAddProductToCart(MouseEvent event){
        SystemController.setProduct(listProducts.getSelectionModel().getSelectedItem());
        if(SystemController.isLogin()){
            PurchaserController purchaserController = new PurchaserController();
            purchaserController.addProductToCart(SystemController.getProduct(),(Purchaser) AccountController.getAccount());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you must login first");
            alert.show();
        }
    }
    @FXML
    void btAddScore(MouseEvent event) {
        SystemController.setProduct(listProducts.getSelectionModel().getSelectedItem());
        if(SystemController.isLogin()){
            PurchaserController purchaserController = new PurchaserController();
            try {
                purchaserController.addScore((Purchaser) AccountController.getAccount(),SystemController.getProduct(),Score.getValue());
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
        SystemController.setProduct(listProducts.getSelectionModel().getSelectedItem());
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
        try {
            lbProduct.setText(listProducts.getSelectionModel().getSelectedItem().toString0());
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please select item");
            alert.show();
        }

    }

    @FXML
    void btExit(javafx.scene.input.MouseEvent event) throws IOException {
        SystemController.setProducts(new ArrayList<>());
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
        if(SystemController.isLogin()){
            SystemController.setProduct(listProducts.getSelectionModel().getSelectedItem());
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
        Arrays.sort(SystemController.getProducts().toArray());
//        listProducts.getItems().addAll(SystemController.getProducts());
        SystemController.setNumberOfProduct(0);
        if (SystemController.getNumberOfProduct()+5<SystemController.getProducts().size()){
            listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getNumberOfProduct()+5));
            SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+5);
        }else {
            listProducts.getItems().addAll(SystemController.getProducts().subList(SystemController.getNumberOfProduct(),SystemController.getProducts().size()));
            SystemController.setNumberOfProduct(SystemController.getNumberOfProduct()+SystemController.getProducts().size());
        }


    }
}
