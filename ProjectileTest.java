package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectileTest extends ApplicationTest  {
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

    @Test
    public void projectileInstantiates() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place1");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place1");

        Tower tower = controller.getTowerList().get(0);
        Minion minion = new Minion();
        Projectile projectile = tower.effectOnEnemy(minion);
        controller.getProjectiles().add(projectile);

        assertFalse(controller.getProjectiles().isEmpty());
    }

    public void rightProjectile() {
        Enemy enemy = new Minion();

        SnowTower snowTower = new SnowTower(0, 0, controller.getGameState());
        Projectile projectile = snowTower.effectOnEnemy(enemy);
        assertTrue(projectile instanceof WaterProjectile);

        FireTower fireTower = new FireTower(0, 0, controller.getGameState());
        projectile = fireTower.effectOnEnemy(enemy);
        assertTrue(projectile instanceof AirProjectile);

        LightingTower lightingTower = new LightingTower(0, 0, controller.getGameState());
        projectile = lightingTower.effectOnEnemy(enemy);
        assertTrue(projectile instanceof RockProjectile);
    }
}