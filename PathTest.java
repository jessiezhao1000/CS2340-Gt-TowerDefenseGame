package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;

import org.testfx.framework.junit5.ApplicationTest;
import java.util.concurrent.TimeUnit;


public class PathTest extends ApplicationTest {
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

    //@Test
    public void enemiesOnPath() throws InterruptedException {
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertEquals(controller.getGameState().getEnemies().get(0).getPosY(), 650);
    }

    //@Test
    public void enemyMovement() throws InterruptedException {
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(controller.getGameState().getEnemies().get(0).getPosX() > 0);
    }
}
