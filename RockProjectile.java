package com.peons.peonstd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.InputStream;

public class RockProjectile extends Projectile {

    private ImageView imageView;

    public RockProjectile(double posX, double posY, double angle) {
        super(posX, posY, angle, 10, 150);

        InputStream stream = null;
        try {
            String imagePath = "src/main/resources/com/peons/peonstd/Rock.png";
            stream = new FileInputStream(imagePath);
        } catch (Exception e) {
            System.out.println("Cannot load image for " + this.getClass().getName());
        }
        assert stream != null;
        Image image = new Image(stream);
        this.imageView = new ImageView(image);
        imageView.setX(posX);
        imageView.setY(posY);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
    }

    @Override
    void updateImage(double x, double y) {
        imageView.setX(x);
        imageView.setY(y);
    }

    @Override
    void removeProjectile() {
        imageView.setDisable(true);
        imageView.setVisible(false);
        this.setFinished();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
