package com.example.linkposag;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LinkPOSController implements Initializable {

    @FXML
    StackPane contentPane;

    @FXML
    Button close;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked((ActionEvent)->{
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        });

        try {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payment-pg.fxml")));
            contentPane.getChildren().removeAll();
            contentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void payment(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("payment-pg.fxml"));
        contentPane.getChildren().removeAll();
        contentPane.getChildren().setAll(fxml);
    }

    public void banks(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("bank-pg.fxml"));
        contentPane.getChildren().removeAll();
        contentPane.getChildren().setAll(fxml);
    }

    public void connection(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("connection-pg.fxml"));
        contentPane.getChildren().removeAll();
        contentPane.getChildren().setAll(fxml);
    }

    public void admin(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("admin-pg.fxml"));
        contentPane.getChildren().removeAll();
        contentPane.getChildren().setAll(fxml);
    }
}
