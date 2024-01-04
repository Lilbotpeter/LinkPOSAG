package com.example.linkposag;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdminController  implements Initializable {


    @FXML
    Button import_button,export_button;

    @FXML
    Pane dragTarget;

    @FXML
    Text dropText;

    @FXML
    private TextField test_text;


    private FileChooser fileChooser;

    public void ChooesFile() {
        fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
//
//        fileChooser.getExtensionFilters().add(extensionFilter);

        import_button.setOnAction(event -> {
            File file = fileChooser.showOpenDialog((Stage) import_button.getScene().getWindow());

            if (file != null) {
                dropText.setText("Imported file : " + file.getName());
                dragTarget.setBackground(new Background(new BackgroundFill(Color.web("#cdfdcd",0.2), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    resetTextField(test_text);
                    test_text.appendText(scanner.nextLine()+" ");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });



    }

    public  void ExportFile(){
        fileChooser = new FileChooser();

        export_button.setOnAction(event -> {
            fileChooser.setTitle("Export File");
            File file = fileChooser.showSaveDialog((Stage)export_button.getScene().getWindow());
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            if (file != null){
                try {

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(test_text.getText());
                    writer.close();

                    System.out.println("Exported data to: "+file.getAbsolutePath());
                    resetForm(dropText,dragTarget);
                    resetTextField(test_text);
                }catch (Exception ignored){

                }
            }
        });

    }

    public void DragDropFile(){
        dragTarget.setOnDragOver(new EventHandler<DragEvent>() {
            private String file;
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard db = dragEvent.getDragboard();
                if (db.hasFiles()){
                    file = db.getFiles().toString();

                    dropText.setText("Selected file : "+file);
                    dragEvent.acceptTransferModes(TransferMode.COPY);

                    dragTarget.setStyle("-fx-border-color: #03478d ");
                    dragTarget.setBackground(new Background(new BackgroundFill(Color.web("#c4d8f6",0.2), CornerRadii.EMPTY, Insets.EMPTY)));


                }else {
                    dragEvent.consume();
                }
            }
        });

        dragTarget.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard db = dragEvent.getDragboard();
                boolean success = false;

                if (db.hasFiles()){
                    success = true;
                    String filename = null;
                    for (File file:db.getFiles()){
                        filename =file.getName();
                        dropText.setText("Imported file : "+filename);

                    }
                    try (Scanner scanner = new Scanner(filename)) {
                        while (scanner.hasNextLine()) {
                            test_text.appendText(scanner.nextLine() + " ");
                        }
                    }
                }
                //dropText.setText("Success");
                dragTarget.setStyle("-fx-border-color: #5fa1ee ");
                dragTarget.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));

                if (success){
                    dragTarget.setBackground(new Background(new BackgroundFill(Color.web("#cdfdcd",0.2), CornerRadii.EMPTY, Insets.EMPTY)));
                }




                dragEvent.setDropCompleted(success);
                dragEvent.consume();
            }
        });

    }

    @FXML
    void reset(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
    }



    @FXML
    void save(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if (file!= null){
            saveSystem(file,test_text.getText());

            if (file.exists()){
                test_text.setText("");
                resetForm(dropText,dragTarget);
            }

        }
    }

    public void saveSystem(File file ,String content){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void  resetTextField(TextField textField){
        textField.setText("");
    }

    public void  resetForm(Text text,Pane pane){
        text.setText("Drag and Drop ");
        pane.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChooesFile();
        ExportFile();
        DragDropFile();








    }
}
