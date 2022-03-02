package com.peons.peonstd;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.InputStream;

public class Zuko extends Enemy {

    public Zuko() {
        super(100, 100, 500, 2);
        InputStream stream = null;
        try {
            String imageFile = "src/main/resources/com/peons/peonstd/zuko.PNG";
            stream = new FileInputStream(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert stream != null;
        super.image = new Image(stream);
    }
}
