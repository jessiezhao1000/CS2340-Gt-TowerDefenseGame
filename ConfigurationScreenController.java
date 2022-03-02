package com.peons.peonstd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfigurationScreenController implements Initializable {

    @FXML
    protected RadioButton easyBtn;
    @FXML
    protected RadioButton medBtn;
    @FXML
    protected RadioButton hardBtn;

    @FXML
    private Label nameDisplay;
    @FXML
    private TextField nameField;
    @FXML
    private Label invalidName;

    @FXML
    protected Button enter;
    @FXML
    protected Button startGame;


    /**
     * Action handler that displays player's name entry after enter button is clicked
     */
    @FXML
    protected void onEnterButtonClicked() {
        String name = nameField.getText();
        if (!name.equals("") && !name.trim().isEmpty()) {
            nameDisplay.setText(String.format("Player Name: %s", name));
            if (invalidName.isVisible()) {
                invalidName.setVisible(false);
            }
        } else {
            invalidName.setVisible(true);
        }
    }

    /**
     * Action handler that goes to game screen when start game button is clicked
     * @throws Exception if file is not found
     */
    @FXML
    private void onStartGameButtonClicked() throws Exception {
        if (nameField.getText().equals("") || nameField.getText().trim().isEmpty()) {
            return;
        }

        Stage stage;

        stage = (Stage) enter.getScene().getWindow();
        String gameViewURL = "game-view.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(gameViewURL));
        Scene gameScreen = new Scene(fxmlLoader.load(), 1000, 1000);
        gameScreen.getStylesheets().add(HelloApplication.class
                .getResource("tower-menu.css").toExternalForm());

        GameController gameController = (GameController) fxmlLoader.getController();

        GameState gameState;
        if (easyBtn.isSelected()) {
            gameState = new GameState(easyBtn.getText());
        } else if (medBtn.isSelected()) {
            gameState = new GameState(medBtn.getText());
        } else {
            gameState = new GameState(hardBtn.getText());
        }

        gameController.setGameState(gameState);
        gameController.setPlayerName(nameField.getText());
        gameController.setTowerCosts();

        stage.setScene(gameScreen);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
