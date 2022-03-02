package com.peons.peonstd;

import javafx.scene.image.ImageView;

import java.lang.Math;

public abstract class Projectile {
    private double posX;
    private double posY;

    private final double angle;
    private final double velocity;

    private double totalDistance;
    private final double finalDistance;

    private boolean finished;

    private ImageView imageView;

    public Projectile(double posX, double posY,
                      double angle, double velocity,
                      double finalDistance) {
        this.posX = posX;
        this.posY = posY;

        this.angle = angle;
        this.velocity = velocity;

        this.totalDistance = 0;
        this.finalDistance = finalDistance;

        this.finished = false;
    }

    public void translate() {
        double newX = posX + velocity * Math.cos(angle);
        double newY = posY + velocity * Math.sin(angle);

        double dx = (newX - posX);
        double dy = (newY - posY);

        double delta = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double newDistance = totalDistance + delta;

        if (newDistance > finalDistance) {
            removeProjectile();
        } else {
            this.posX = newX;
            this.posY = newY;
            updateImage(posX, posY);
            this.totalDistance = newDistance;
        }
    }

    public boolean isFinished() {
        return finished;
    }

    protected void setFinished() {
        this.finished = true;
    }

    public ImageView getImageView() {
        return imageView;
    }

    abstract void removeProjectile();
    abstract void updateImage(double x, double y);
}
