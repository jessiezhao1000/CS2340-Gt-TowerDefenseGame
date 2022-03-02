package com.peons.peonstd;

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


public class JessieTest extends ApplicationTest {
    private HelloController test = new HelloController();
    private Pane root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("hello-view.fxml"));
        this.root = fxmlLoader.load();
        test = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();

    }

    @Test
    public void testStart() {

        clickOn("#start");
        verifyThat("#nameDisplay", Node::isVisible);

    }

    @Test
    public void rightText() {
        String expectedText = test.getHelloText().getText();
        assertEquals(expectedText, test.getHelloText().getText());
    }


}

