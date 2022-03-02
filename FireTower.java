package com.peons.peonstd;

import javafx.scene.layout.Pane;

import java.io.IOException;

public class FireTower extends Tower {
    @Override
    public Projectile effectOnEnemy(Enemy enemy) {
        int distance = (int) Math.sqrt(Math.pow((x - enemy.getPosX()), 2) + Math.pow((y - 590), 2));
        if (distance <= 200) {
            super.effectOnEnemy(enemy);
            double angle = calculateAngle(enemy.getPosX()-60, enemy.getPosY());
            return new AirProjectile(x+40, y+40, angle);
        } else {
            return null;
        }
    }

    private String imagePath = "src/main/resources/com/peons/peonstd/aang.png";

    /**
     * default range of the tower
     */
    private static int range = 55;
    /**
     * default build cost of the tower
     */
    private int buildCost = 800;
    /**
     * default upgrade cost of the tower
     */
    private static int upgradeCost = 6;

    /**
     * cost increase each time difficulty change
     *
     * @param x2        cord
     * @param y2        cord
     * @param gameState difficulty
     */
    public FireTower(int x2, int y2, GameState gameState) {
        super(x2, y2, 10, 60, gameState);
        if (gameState.getDifficulty().equals("Easy")) {
            this.buildCost *= 1;
        } else if (gameState.getDifficulty().equals("Medium")) {
            this.buildCost *= 1.25;
        } else {
            this.buildCost *= 1.5;
        }
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void drawTower(String imagePath, int x, int y,
                          int width, int height, Pane root) throws IOException {
        super.drawTower(this.imagePath, x, y, 140, 140, root);
    }


    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
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

