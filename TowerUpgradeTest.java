import com.peons.peonstd.GameController;
import com.peons.peonstd.GameState;
import com.peons.peonstd.Tower;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

public class TowerUpgradeTest extends ApplicationTest {
    private GameController controller;

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void upgradeTower() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place1");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place1");
        clickOn("upgrade1");
        Tower tower = controller.getTowerList().get(0);

        assertNotEquals(3, tower.getAttackPower());
    }

    @Test
    public void upgradeFunds() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place1");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place1");
        controller.getGameState().setMoney(0);
        clickOn("upgrade1");
        verifyThat("#insufficientFunds", Node::isVisible);
    }
}