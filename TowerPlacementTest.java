package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobotException;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;

public class TowerPlacementTest extends ApplicationTest {
    private GameController controller = new GameController();

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        controller.setGameState(new GameState("Easy"));
        controller.setPlayerName("Hannah");
        controller.setTowerCosts();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    /**
     * Tests that the tower is placed in the position the user chooses
     */
    @Test
    public void towerPositionTest() {
        Pane pane = controller.getPane1();
        Button btn = (Button) pane.lookup("#place4");
        int btnX = (int) btn.getLayoutX();
        int btnY = (int) btn.getLayoutY();

        clickOn("#tower1");
        clickOn("#place4");

        Node imageView = null;
        for (Node node : pane.getChildren()) {
            if (node instanceof ImageView) {
                imageView = (ImageView) node;
            }
        }

        Assertions.assertEquals(true, imageView.getBoundsInParent().
                contains((double) btnX, (double) btnY));

    }

    /**
     * Checks that an error is thrown if the user tries to click the same place button twice
     * Ensures that two towers cannot be put in the same position
     */
    @Test
    public void overlappingTowersTest() {
        clickOn("#tower2");
        clickOn("#place2");
        Assertions.assertThrows(FxRobotException.class, () -> clickOn("#place2"));
    }

    @Test
    public void testStartCombat() {
        clickOn("#startCombat");
        verifyThat("#startCombat", Node::isDisable);
    }

    @Test
    public void testRightText() {
        String expectedText = "Start Combat!";
        Assertions.assertEquals(expectedText, controller.getStartCombatText());
    }

}
