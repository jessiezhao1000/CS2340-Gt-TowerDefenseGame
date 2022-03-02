package com.peons.peonstd;

/**
 * handles all the behind the scenes calculations for the game passed in through the controller
 */
public class GameEngine {

    /**
     * Changes player variables after purchasing a tower
     * @param currentState the current game state
     * @param tower the tower the user is trying to buy
     * @return returns whether there's enough money to buy the tower
     */
    private int numTowers = 0;
    public boolean purchaseTower(GameState currentState, Tower tower) {
        if (currentState.getMoney() < tower.getBuildCost()) {
            return false;
        } else {
            this.numTowers++;
            currentState.setMoney(currentState.getMoney() - tower.getBuildCost());
            return true;
        }
    }

    /**
     * Upgrades the tower the user chooses
     * @param currentState
     * @param tower
     * @return
     */
    public boolean upgradeTower(GameState currentState, Tower tower) {
        if (currentState.getMoney() < tower.getUpgradeCost()) {
            return false;
        } else {
            tower.upgrade();
            currentState.setMoney(currentState.getMoney() - tower.getUpgradeCost());
            return true;
        }
    }

    /**
     * returns the number of towers
     * @return the number of towers clicked on
     */
    public int getNumTowers() {
        return numTowers;
    }

}