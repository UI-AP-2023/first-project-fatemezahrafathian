package com.example.demo1;

import Controller.AccountController;
import Controller.PurchaserController;
import Model.Exception.DiscountException;
import Model.Exception.InvalidPurchase;
import Model.Product.Product;
import Model.User.CartClass;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Cart implements Initializable {
    private double price=0;
    @FXML
    private ListView<Product> listProduct;

    @FXML
    private ImageView exitImage;

    @FXML
    private Label lbPrice;

    @FXML
    private TextField tfDiscount;

    @FXML
    private Button btExit;

    @FXML
    private Button btBuy;

    @FXML
    private Button btDiscount;


    @FXML
    void btBuy(MouseEvent event) {
        PurchaserController purchaserController = new PurchaserController();
        try {
            purchaserController.buy((Purchaser) AccountController.getAccount());
            ((Purchaser) AccountController.getAccount()).setCart(new CartClass());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("purchase is successful");
            alert.show();
        } catch (InvalidPurchase e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }

    @FXML
    void btDiscount(MouseEvent event) {
        PurchaserController purchaserController = new PurchaserController();
        try {
            purchaserController.useDiscountCode((Purchaser)(AccountController.getAccount()),tfDiscount.getText());
            lbPrice.setText(String.valueOf(price));
        } catch (DiscountException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Product product: ((Purchaser)(AccountController.getAccount())).getCart().getCart()){
            price+=product.getPrice();
        }
        lbPrice.setText(String.valueOf(price));
        listProduct.getItems().addAll(((Purchaser)(AccountController.getAccount())).getCart().getCart());
    }
}
