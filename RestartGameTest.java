import com.peons.peonstd.GameController;
import com.peons.peonstd.GameOverController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;

public class RestartGameTest extends ApplicationTest {
    private GameOverController controller;
    public void start(Stage stage) throws Exception {
        String url = "gameOver.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameOverController) loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testRestart() {
        verifyThat("#restart", Node::isVisible);
    }

}
