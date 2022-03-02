import com.peons.peonstd.GameController;
import com.peons.peonstd.GameOverController;
import com.peons.peonstd.GameState;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class GameOverTest extends ApplicationTest {
    private GameController controller;

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameOverController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Hard"));
        controller.setPlayerName("Hannah");
        controller.getGameState().setMonumentHealth(1);
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }
    //@Test
    public void enemyMovement() throws InterruptedException {
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(controller.getGameState().getEnemies().get(0).getPosX() > 0);
    }

    @Test
    public void enemiesOnPath() throws InterruptedException {
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertEquals(controller.getGameState().getEnemies().get(0).getPosY(), 650);
    }

    /**
     * Checks that the game over screen is displayed when monument health is <= 0
     */
    @Test
    public void testGameOver() throws InterruptedException {
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(20);
        verifyThat("#restart", Node::isVisible);
    }
}
