package com.peons.peonstd;

import org.testfx.framework.junit5.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyHealthBarTest extends ApplicationTest {
    private GameController controller;


    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Tests to see if the health bar size decreases after the enemy takes damage
     */
    @Test
    public void healthBarDecrements() {
        clickOn("#startCombat");
        GameState gameState = controller.getGameState();
        Enemy enemy = gameState.getEnemies().get(0);
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        enemy.damageHealth(1);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(43 * (double) enemy.health / enemy.originalHealth, enemy.healthBar.getWidth());
    }

    /**
     * Tests to see if the health bar follows the enemy sprite
     */
    @Test
    public void healthBarFollows() {
        clickOn("#startCombat");
        GameState gameState = controller.getGameState();
        Enemy enemy = gameState.getEnemies().get(0);
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(enemy.healthBar.getX(), enemy.getPosX());
        assertEquals(enemy.healthBar.getY(), enemy.getPosY());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(enemy.healthBar.getX(), enemy.getPosX());
        assertEquals(enemy.healthBar.getY(), enemy.getPosY());
    }
}