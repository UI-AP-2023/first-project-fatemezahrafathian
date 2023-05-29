package com.example.demo1;

import Controller.AccountController;
import Model.Product.Product;
import Model.User.DiscountCode;
import Model.User.PurchaseInvoice;
import Model.User.Purchaser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class History implements Initializable {

    @FXML
    private ListView<PurchaseInvoice> listInvoice;

    @FXML
    private Label lbInvoice;

    @FXML
    private Rectangle box;

    @FXML
    void listInvoice(MouseEvent event) {
        try {
            lbInvoice.setText((listInvoice.getSelectionModel().getSelectedItem()).toString0());
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please select item");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AccountController accountController =new  AccountController();
        listInvoice.getItems().addAll(((Purchaser)(AccountController.getAccount())).getPurchaseHistory());
    }
}
