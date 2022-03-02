import com.peons.peonstd.Enemy;
import com.peons.peonstd.GameController;
import com.peons.peonstd.GameState;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyCombatTest extends ApplicationTest  {
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
    public void towerAttacksEnemy() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place4");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place4");
        clickOn("#startCombat");
        GameState gameState = controller.getGameState();
        Enemy enemy = gameState.getEnemies().get(0);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotEquals(60, enemy.getHealth());

    }

    @Test
    public void allEnemiesDie() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place4");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place4");
        clickOn("#startCombat");
        GameState gameState = controller.getGameState();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(180, gameState.getMonumentHealth());
    }
}