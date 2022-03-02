import com.peons.peonstd.GameController;
import com.peons.peonstd.GameOverController;
import com.peons.peonstd.GameState;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class GameWonTest extends ApplicationTest {
    private GameController controller;

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameOverController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        controller.setPlayerName("Hannah");
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testGameOver() throws InterruptedException {
        clickOn("#tower3");
        clickOn("#place1");
        clickOn("#place2");
        clickOn("#startCombat");
        TimeUnit.SECONDS.sleep(20);
        verifyThat("#restartWon", Node::isVisible);
    }

    @Test
    public void testEnemiesKilledCount() throws InterruptedException {
        clickOn("#tower3");
        clickOn("#place1");
        clickOn("#place2");
        clickOn("#startCombat");

        TimeUnit.SECONDS.sleep(20);

        Assertions.assertTrue(controller.getGameState().getTotalDamageDealt() != 0);
    }



}
