package com.example.demo1;

import Model.SystemController;
import Model.User.Comment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

public class ShowComment implements Initializable {
    @FXML
    private ImageView exitImage;

    @FXML
    private Label lbComment;

    @FXML
    private Rectangle box;

    @FXML
    private ListView<Comment> listComment;

    @FXML
    private Button btExit;

    @FXML
    void listComment(MouseEvent event) {
        try {
            lbComment.setText(listComment.getSelectionModel().getSelectedItem().toString0());
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please select item");
            alert.show();
        }

    }
    @FXML
    void btExit(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent,800,450);
        stage.setScene(scene);
        stage.setTitle("Search");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listComment.getItems().addAll(SystemController.getProduct().getComments());
    }
}
