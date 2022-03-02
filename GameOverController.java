package com.peons.peonstd;

import javafx.application.Platform;
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

public class GameOverController implements Initializable {
    private int enemiesKilled;
    private int damageDealt;
    private int healthLost;


    public GameOverController() {
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }
    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }
    public void setHealthLost(int healthLost) {
        this.healthLost = healthLost;
    }

    @FXML
    private Label enemiesKilledWon;
    public void setEnemiesKilledWonLabel() {
        enemiesKilledWon.setText(enemiesKilledWon.getText() + enemiesKilled);
        System.out.println(enemiesKilled);
    }

    @FXML
    private Label damageDealtWon;
    public void setDamageDealtWonLabel() {
        damageDealtWon.setText(damageDealtWon.getText() + damageDealt);

    }

    @FXML
    private Label healthLostWon;
    public void setHealthLostWonLabel() {
        healthLostWon.setText(healthLostWon.getText() + healthLost);
    }

    @FXML
    private Label enemiesKilledLost;
    public void setEnemiesKilledLostLabel() {
        enemiesKilledLost.setText(enemiesKilledLost.getText() + enemiesKilled);
    }

    @FXML
    private Label damageDealtLost;
    public void setDamageDealtLostLabel() {
        damageDealtLost.setText(damageDealtLost.getText() + damageDealt);
    }

    @FXML
    private Label healthLostLost;
    public void setHealthLostLostLabel() {
        healthLostLost.setText(healthLostLost.getText() + healthLost);
    }

    @FXML
    private Button restart;

    @FXML
    private Button exit;

    @FXML
    protected void onReStartButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) exit.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    @FXML
    private Button closeWon;
    @FXML
    protected void onReStartWonButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) closeWon.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    @FXML
    protected void onExitButtonClick(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
