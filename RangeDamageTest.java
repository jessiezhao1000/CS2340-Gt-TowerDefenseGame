import com.peons.peonstd.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangeDamageTest extends ApplicationTest {
    private GameController controller;
    private String difficulty1 = "Easy";
    private GameState gameState = new GameState(difficulty1);
    private int lightAttack = 34;
    private int snowAttack = 3;
    private int fireAttack = 10;
    private LightingTower lightingTower = new LightingTower(1, 2, gameState);
    private SnowTower snowTower = new SnowTower(1, 2, gameState);
    private FireTower fireTower = new FireTower(1, 2, gameState);
    private int posX = 850;


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
    public void enemyInRange() {
        GameState gameState = controller.getGameState();
        Enemy enemy = gameState.getEnemies().get(0);
        assertTrue(enemy.getPosX() < posX);
    }

    @Test
    public void rightDamage() {
        Assertions.assertEquals(lightingTower.getAttackPower(), lightAttack);
        Assertions.assertEquals(snowTower.getAttackPower(), snowAttack);
        Assertions.assertEquals(fireTower.getAttackPower(), fireAttack);
    }
}