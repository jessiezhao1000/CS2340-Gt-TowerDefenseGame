package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class TowerBought extends ApplicationTest {
    private GameController controller;


    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        controller.setPlayerName("Tamara");
        controller.setTowerCosts();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testMoney() {
        Assertions.assertEquals(2000, controller.getGameState().getMoney());
        clickOn("#tower1");
        clickOn("#place1");
        Assertions.assertEquals(24595, controller.getGameState().getMoney());
    }
    @Test
    public void testNumTowers() {
        Assertions.assertEquals(0, controller.getGameEngine().getNumTowers());
        clickOn("#tower1");
        clickOn("#place2");
        Assertions.assertEquals(1, controller.getGameEngine().getNumTowers());
    }
}
