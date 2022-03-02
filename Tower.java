package com.peons.peonstd;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class Tower {

    private GameState gameState;
    private Enemy coords;

    /**
     * draw images of tower
     *
     * @param images image path
     * @param x      cord
     * @param y      cord
     * @param root   root
     * @param height height
     * @param width width
     * @throws IOException file not found
     */
    public void drawTower(String images, int x, int y, int width,
                          int height, Pane root) throws IOException {
        InputStream stream = new FileInputStream(images);
        Image image = new Image(stream);
        ImageView imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);
    }
    /**
     * damages enemy within a certain range, override with effects for each tower
     * @param enemy enemy
     */
    public Projectile effectOnEnemy(Enemy enemy) {
        // check that enenmy is within range
        int distance = (int) Math.sqrt(Math.pow((x - enemy.getPosX()), 2) + Math.pow((y - 590), 2));
        if (distance <= 200) {
            enemy.damageHealth(attackPower);
        }
        return null;
    }

    protected int x;
    protected int y;

    /**
     * damages enemy within a certain range, override with effects for each tower
     * @param enemy enemy
     */

    /**
     * default attack power of the tower
     */
    private int attackPower;
    /**
     * default range of the tower
     */
    private static int range = 65;
    /**
     * default build cost of the tower
     */
    private int buildCost = 2;
    /**
     * default upgrade cost of the tower
     */
    private static int upgradeCost = 1;

    /**
     * uppgrade attack power each level
     */
    public void upgrade() {
        attackPower += 1;
    }

    private int framesPerAttack;

    /**
     * constructor for tower
     *
     * @param x2        cord
     * @param y2        cord
     * @param attackPower attack power
     * @param gameState access for difficulty
     */

    public Tower(int x2, int y2,
                 int attackPower, int framesPerAttack,
                 GameState gameState) {
        this.x = x2;
        this.y = y2;
        this.attackPower = attackPower;
        this.framesPerAttack = framesPerAttack;
    }

    /**
     * setter for buldcost
     *
     * @param buildCost cost
     */
    public void setBuildCost(int buildCost) {
        this.buildCost = buildCost;

    }

    /**
     * getter for x
     *
     * @return x
     */
    public abstract int getX();

    /**
     * getter for y
     *
     * @return y
     */
    public abstract int getY();

    /**
     * getter for build cost
     * @return returns the cost of the tower
     */
    public abstract int getBuildCost();

    /**
     * getter for the upgrade cost of the tower
     * @return
     */
    public abstract int getUpgradeCost();

    /**
     * setter for y
     *
     * @param x cord
     */
    public abstract void setX(int x);

    /**
     * setter for y
     *
     * @param y cord
     */
    public abstract void setY(int y);

    public int getRange() {
        return range;
    }
    public void setRange() {
        this.range = range;
    }

    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Number of frames before attack
     * @return number of frames
     */
    public int getFramesPerAttack() {
        return framesPerAttack;
    }

    protected double calculateAngle(double targetX, double targetY) {
        return Math.atan2(targetY-x, targetX-y);
    }
}

