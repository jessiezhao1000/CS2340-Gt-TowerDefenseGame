package com.peons.peonstd;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.InputStream;

public class Azula extends Enemy {

    public Azula() {
        super(60, 50, 200, 2);
        InputStream stream = null;
        try {
            String imageFile = "src/main/resources/com/peons/peonstd/azula2.png";
            stream = new FileInputStream(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert stream != null;
        super.image = new Image(stream);
    }
}
