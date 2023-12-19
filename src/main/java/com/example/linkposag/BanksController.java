package com.example.linkposag;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BanksController extends Application {


    @FXML
    Button payment_button,banks_button,connectio_button,admin_button;

    public void toPaymentPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("payment-pg.fxml"));

        Stage window = (Stage)payment_button.getScene().getWindow() ;
        final Scene scene = new Scene(root,1266,767);
        window.setFullScreen(false);

        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
