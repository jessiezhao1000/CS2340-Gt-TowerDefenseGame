import com.peons.peonstd.GameController;
import com.peons.peonstd.GameState;
import com.peons.peonstd.Minion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyInstantiationTest extends ApplicationTest {
    private GameController controller;

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("easy"));
        controller.setPlayerName("Daniel");
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }


    /**
    * Checks that monument health decreases after a minion hits it
    */
    @Test
    public void enemyValues() throws InterruptedException {
        Minion minion = new Minion();
        assertEquals(30, minion.getDamage());
        assertEquals(1, minion.getSpeed());
    }

    /**
     * Checks that enemies don't exist prior to combat
     * @throws InterruptedException exception
     */
    @Test
    public void enemiesEmptyBeforeCombat() throws InterruptedException {
        assertEquals(0, controller.getGameState().getEnemies().size());
    }
}
