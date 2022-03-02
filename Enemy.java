package com.peons.peonstd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * Abstract class for an Enemy. Different enemies inherit this
 */
public abstract class Enemy {

    //Position variables
    private double posX;
    private double posY;

    //Specific enemy characteristics
    protected int health;
    protected final int originalHealth;
    private final int damage;
    private final int coinReward;
    private final int speed;
    private boolean dead;

    //Enemy style characteristics
    protected Image image;
    private ImageView imageView;
    protected Rectangle healthBar;

    /**
     * Generic contructor for an enemy
     * @param health Starting health
     * @param damage Amount of damage to tower
     * @param coinReward Reward for killing
     * @param speed Movement speed multiplier
     */
    public Enemy(int health, int damage, int coinReward, int speed) {
        this.posX = 0;
        this.posY = 0;

        this.health = health;
        this.originalHealth = health;
        this.damage = damage;

        this.coinReward = coinReward;
        this.speed = speed;

        this.dead = false;
    }

    /**
     * Draws image on screen. Will remove previous image if already on screen
     * @param x X position on screen
     * @param y Y position on screen
     * @param root Screen
     */
    public void drawEnemy(double x, double y, Pane root) {
        if (imageView == null) {
            imageView = new ImageView(image);
            this.healthBar = new Rectangle(43, 5,
                   Color.RED);
            this.posX = x;
            this.posY = y;
            imageView.setX(x);
            imageView.setY(y);
            this.healthBar.setX(x);
            this.healthBar.setY(y);
            this.healthBar.setFill(Color.RED);
            imageView.setFitHeight(75);
            imageView.setFitWidth(75);
            imageView.setPreserveRatio(true);
            imageView.setVisible(true);
            root.getChildren().add(imageView);
            root.getChildren().add(healthBar);
            return;
        }
        this.posX = x;
        this.posY = y;
        imageView.setX(x);
        imageView.setY(y);
        this.healthBar.setX(x);
        this.healthBar.setY(y);
        this.healthBar.setWidth(75 * ((double) health / originalHealth));
    }

    /**
     * Sets health for enemy
     * @param  damage damage
     *
     */
    public void damageHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            this.dead = true;
            this.healthBar.setWidth(0);
            this.getImageView().setVisible(false);
        }
    }

    /**
     * Current enemy x position
     * @return current enemy x position
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Current enemy y position
     * @return current enemy y position
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Reward for killing this enemy
     * @return enemy reward
     */
    public int getCoinReward() {
        return coinReward;
    }

    /**
     * How much damage the enemy does to a mounment
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Movement speed multiplier for enemy
     * @return speed multiplier
     */
    public int getSpeed() {
        return speed;
    }

    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
