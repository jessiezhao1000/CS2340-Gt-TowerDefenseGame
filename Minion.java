package com.peons.peonstd;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Unique type of enemy
 */
public class Minion extends Enemy {

    /**
     * Default constructor for a minion
     * @throws IOException when image cannot be loaded
     */
    public Minion() {
        super(20, 30, 100, 1);
        InputStream stream = null;
        try {
            String imageFile = "src/main/resources/com/peons/peonstd/fireminion.png";
            stream = new FileInputStream(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert stream != null;
        super.image = new Image(stream);
    }
}
