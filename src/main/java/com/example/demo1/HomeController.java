package com.example.demo1;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;




public class HomeController {
    private static boolean login=false;

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        HomeController.login = login;
    }

    @FXML
    private Button searchButton;

    @FXML
    private Button btPerson;

    @FXML
    private Button btStationary;

    @FXML
    private ImageView digitalGood;

    @FXML
    private Button btEdible;

    @FXML
    private ImageView stationary;

    @FXML
    private ImageView car;

    @FXML
    private ImageView person;

    @FXML
    private ImageView homeBackgrand;

    @FXML
    private Button btCar;

    @FXML
    private ImageView edible;

    @FXML
    private Button btDigitalGoods;

    @FXML
    private TextField searchBox;

    @FXML
    void edible(MouseEvent event) {

    }
    @FXML
    void car(MouseEvent event) {

    }
    @FXML
    void stationary(MouseEvent event) {

    }
    @FXML
    void digitalGoods(MouseEvent event) {

    }
    @FXML
    void SearchButton(MouseEvent event) throws IOException {

    }

    @FXML
    void btPerson(MouseEvent event) throws IOException {
        if(login){
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("profile");
            stage.show();
        }else {
            Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(parent,800,450);
            stage.setScene(scene);
            stage.setTitle("login");
            stage.show();
        }

    }

}