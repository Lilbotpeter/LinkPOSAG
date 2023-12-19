package com.example.linkposag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LinkPOSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment-pg.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getBounds();
        //String css = this.getClass().getResource("application.css").toExternalForm();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("LinkPOS Agent");
        stage.setMaximized(true);
        //stage.setFullScreen(true);
        //scene.getStylesheets().add(css);
        stage.setX(bounds.getMaxX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}