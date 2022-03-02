package com.peons.peonstd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;


import static org.junit.jupiter.api.Assertions.*;

public class TowerMenuTest extends ApplicationTest {
    private GameController controller;

    public void start(Stage stage) throws Exception {
        String url = "game-view.fxml";
        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(url));
        Pane root = loader.load();
        this.controller = (GameController) loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    public void towerMenuExists() {
        //Labels with costs exist
        assertNotNull(controller.tower1Label);
        assertNotNull(controller.tower2Label);
        assertNotNull(controller.tower3Label);

        //Radio button group for tower selection exists
        assertNotNull(controller.towerMenuGroup);
    }

    @Test
    public void rightTowerSelected() {
        clickOn("#tower1");
        RadioButton button = (RadioButton) controller.towerMenuGroup.getSelectedToggle();
        String buttonText = button.getText();
        assertEquals("Waterbender", buttonText);

        clickOn("#tower2");
        button = (RadioButton) controller.towerMenuGroup.getSelectedToggle();
        buttonText = button.getText();
        assertEquals("Airbender", buttonText);

        clickOn("#tower3");
        button = (RadioButton) controller.towerMenuGroup.getSelectedToggle();
        buttonText = button.getText();
        assertEquals("Earthbender", buttonText);
    }
}