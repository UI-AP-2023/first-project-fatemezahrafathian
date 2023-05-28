package com.example.demo1;


import Controller.ProductController;
import Model.Product.Product;
import Model.Product.ProductCategory;
import Model.User.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    private static ArrayList<Product> products = new ArrayList<>();

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        HomeController.products = products;
    }

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

    public TextField getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(TextField searchBox) {
        this.searchBox = searchBox;
    }

    @FXML
    void btEdible(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        productController.filterCategory(products, ProductCategory.EDIBLE);
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("filterEdible.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Filter");
        stage.show();

    }
    @FXML
    void btCar(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        productController.filterCategory(products, ProductCategory.VEHICLES);
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("filterVehicle.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Filter");
        stage.show();

    }
    @FXML
    void btStationary(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        productController.filterCategory(products, ProductCategory.STATIONERY);
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("filterStationary.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Filter");
        stage.show();
    }
    @FXML
    void btDigitalGoods(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        productController.filterCategory(products, ProductCategory.DIGITAL_GOODS);
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("filterDigitalGoods.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Filter");
        stage.show();

    }
    @FXML
    void searchButton(MouseEvent event) throws IOException {
        ProductController productController = new ProductController();
        products.addAll(productController.search(searchBox.getText()));
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Search");
        stage.show();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products=new ArrayList<>();
    }
}