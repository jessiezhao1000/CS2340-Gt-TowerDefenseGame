package com.peons.peonstd;

import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class LightingTower extends Tower {
    private String imagePath = "src/main/resources/com/peons/peonstd/Toph.png";

    /**
     * default range of the tower
     */
    private static int range = 35;
    /**
     * default build cost of the tower
     */
    private int buildCost = 1000;
    /**
     * default upgrade cost of the tower
     */
    private static int upgradeCost = 8;

    private ArrayList<Projectile> projectiles = new ArrayList<>();


    /**
     * cost increase each time difficulty change
     *
     * @param x2        cord
     * @param y2        cord
     * @param gameState difficulty
     */
    public LightingTower(int x2, int y2, GameState gameState) {
        super(x2, y2, 34, 120, gameState);
        if (gameState.getDifficulty().equals("Easy")) {
            this.buildCost *= 1;
        } else if (gameState.getDifficulty().equals("Medium")) {
            this.buildCost *= 1.25;
        } else {
            this.buildCost *= 1.5;
        }
    }


    @Override
    public void drawTower(String imagePath, int x, int y,
                          int width, int height, Pane root) throws IOException {
        super.drawTower(this.imagePath, x, y, 100, 100, root);
    }

    public Projectile effectOnEnemy(Enemy enemy) {
        int distance = (int) Math.sqrt(Math.pow((x - enemy.getPosX()), 2) + Math.pow((y - 590), 2));
        if (distance <= 200) {
            super.effectOnEnemy(enemy);
            double angle = calculateAngle(enemy.getPosX()-40, enemy.getPosY());
            return new RockProjectile(x+50, y+50, angle);
        } else {
            return null;
        }
    }
    /**
     * getter for x
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter for y
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * setter for x
     *
     * @param x cord
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter for y
     *
     * @param y cord
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter for build cost
     *
     * @return buildcost
     */
    public int getBuildCost() {
        return buildCost;
    }

    /**
     * getter for imagepath
     *
     * @return imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * getter for the upgrade cost for the tower
     * @return
     */
    public int getUpgradeCost() {
        return upgradeCost;
    }
}


