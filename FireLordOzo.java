package com.peons.peonstd;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.InputStream;

public class FireLordOzo extends Enemy {

    public FireLordOzo() {
        super(100, 70, 400, 1);
        InputStream stream = null;
        try {
            String imageFile = "src/main/resources/com/peons/peonstd/Ozai.png";
            stream = new FileInputStream(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert stream != null;
        super.image = new Image(stream);
    }
}
