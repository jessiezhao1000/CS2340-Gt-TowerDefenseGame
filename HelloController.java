package com.peons.peonstd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Organize into screens and functionality
//Refactor into different Controllers based on Scenes.
//Button sets scenes, but each scene has a different controller.
public class HelloController implements Initializable {

    @FXML
    private Button start;
    @FXML
    private Label helloText;

    @FXML
    protected void onStartButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) start.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("InitialConfigurationScreenFXML.fxml"));

        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *
     *
     * @return start
     */
    public Button getStart() {
        return start;
    }

    /**
     *
     * @return helloText
     */
    public Label getHelloText() {
        return helloText;
    }
}