package com.example.demo1;

import Controller.AccountController;
import Model.User.DiscountCode;
import Model.User.Purchaser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Discounts implements Initializable {

    @FXML
    private Label lbDiscount;

    @FXML
    private ImageView exitImage;

    @FXML
    private Rectangle box;

    @FXML
    private ListView<DiscountCode> listDiscounts;

    @FXML
    private Button btExit;

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
    void listDiscounts(MouseEvent event) {
        lbDiscount.setText((listDiscounts.getSelectionModel().getSelectedItem()).toString0());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listDiscounts.getItems().addAll(((Purchaser)(AccountController.getAccount())).getDiscountCodes());
    }
}
