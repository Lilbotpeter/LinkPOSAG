package com.example.linkposag;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogController implements Initializable {

    @FXML
    Text dismiss,status_in,status_re;

    @FXML
    CheckBox in_bank,re_bank;


    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            Stage stage = (Stage)dismiss.getScene().getWindow();
            stage.close();
        }
    };

    public void promoteCheck(CheckBox checkBox,Text status){
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    status.setText("\uD83D\uDDF8 Enable");
                    status.setStyle("-fx-fill: green");
                }else {
                    status.setText("x Disable");
                    status.setStyle("-fx-fill: red");
                }

            }
        });

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dismiss.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
        promoteCheck(in_bank,status_in);
        promoteCheck(re_bank,status_re);








    }
}
