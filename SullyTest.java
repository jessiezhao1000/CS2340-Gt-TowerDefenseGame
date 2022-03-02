package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

public class SullyTest extends ApplicationTest {
    private GameController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource("game-view.fxml"));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();

        GameState gameState = new GameState("Medium");
        controller.setGameState(gameState);
    }

    @Test
    public void gameScreenTest() {
        Label coinLabel = controller.getCoinLevel();
        Label healthLabel = controller.getHealthLevel();

        assertTrue(coinLabel.isVisible());
        assertTrue(coinLabel.getText().equals("Coins: 1500"));

        assertTrue(healthLabel.isVisible());
        assertTrue(healthLabel.getText().equals("Health: 150"));
    }

    public GameController getController() {
        return controller;
    }
}
