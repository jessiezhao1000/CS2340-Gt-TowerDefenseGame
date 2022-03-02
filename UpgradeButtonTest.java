package com.peons.peonstd;

import com.peons.peonstd.GameController;
import com.peons.peonstd.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;


public class UpgradeButtonTest extends ApplicationTest {
    private GameController test = new GameController();
    private Pane root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("game-view.fxml"));
        this.root = fxmlLoader.load();
        test = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();

    }

    @Test
    public void testUpgrade() {
        clickOn("#upgrade1");
        verifyThat("#upgrade1", Node::isVisible);
    }

    @Test
    public void rightText() {
        String expectedText = "Upgrade";
        assertEquals(expectedText, test.getUpgrade1().getText());

    }


}

