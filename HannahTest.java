import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import com.peons.peonstd.ConfigurationScreenController;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class HannahTest extends ApplicationTest {
    private Pane root;
    private Stage primaryStage;
    private ConfigurationScreenController controller;


    @Override
    public void start(Stage stage) throws Exception {
        String url = "InitialConfigurationScreenFXML.fxml";
        FXMLLoader loader = new FXMLLoader(ConfigurationScreenController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (ConfigurationScreenController) loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    /**
     * Tests an invalid name entry
     */
    @Test
    public void testNameEntry() {
        verifyThat("#enter", hasText("Enter"));
        clickOn("#nameField");
        write("      ");
        clickOn("#enter", MouseButton.PRIMARY);
        verifyThat("#invalidName", Node::isVisible);
    }
}
