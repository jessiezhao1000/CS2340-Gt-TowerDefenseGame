import com.peons.peonstd.GameController;
import com.peons.peonstd.GameState;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit5.ApplicationTest;


public class TowerPurchaseTest extends ApplicationTest {
    private GameController controller;
    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        controller.setPlayerName("Daniel");
        controller.setTowerCosts();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    /**
     * Makes sure that the player price reduces
     */
    @Test
    public void priceReduces() {
        controller.getGameState().setMoney(405);
        clickOn("#tower1");
        clickOn("#place4");
        Assertions.assertNotEquals(controller.getGameState().getMoney(), 405);
    }

    /**
     * Makes sure that the player has sufficient funds to buy a tower
     */
    @Test
    public void sufficientFunds() {
        // tries to buy a tower without enough money
        controller.getGameState().setMoney(300);
        clickOn("#tower1");
        clickOn("#place4");
        // tries to purchase tower without having enough money
        // checks to make sure that the insufficient funds has shown
        verifyThat("#insufficientFunds", Node::isVisible);
    }
}
