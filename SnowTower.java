package com.peons.peonstd;


import javafx.scene.layout.Pane;


import java.io.IOException;

public class SnowTower extends Tower {

    private String imagePath = "src/main/resources/com/peons/peonstd/Katara.png";

    /**
     * default range of the tower
     */
    private static int range = 65;
    /**
     * default build cost of the tower
     */
    private int buildCost = 400;
    /**
     * default upgrade cost of the tower
     */
    private static int upgradeCost = 5;

    /**
     * cost increase each time difficulty change
     *
     * @param x2        cord
     * @param y2        cord
     * @param gameState difficulty
     */
    public SnowTower(int x2, int y2, GameState gameState) {
        super(x2, y2, 3, 30, gameState);
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
        super.drawTower(this.imagePath, x, y, 120, 120, root);
    }

    @Override
    public Projectile effectOnEnemy(Enemy enemy) {
        int distance = (int) Math.sqrt(Math.pow((x - enemy.getPosX()), 2) + Math.pow((y - 590), 2));
        if (distance <= 200) {
            super.effectOnEnemy(enemy);
            double angle = calculateAngle(enemy.getPosX()-60, enemy.getPosY());
            return new WaterProjectile(x+60, y+60, angle);
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

    public int getRange() {
        return range;
    }

    /**
     * sets the range for the tower
     */
    public void setRange() {
        this.range = range;
    }

    /**
     * getter for the upgrade cost for the tower
     * @return
     */
    public int getUpgradeCost() {
        return upgradeCost;
    }

}
