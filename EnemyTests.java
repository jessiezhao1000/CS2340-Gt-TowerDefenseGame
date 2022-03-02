package com.peons.peonstd;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class EnemyTests {

    /**
     * Tests default constructor for minion
     */
    @Test
    public void enemyInit() throws IOException {
        Enemy enemy = new Minion();
        enemy.drawEnemy(0, 0, new Pane());
        enemy.damageHealth(20);
        assertTrue(enemy.isDead());
        assertEquals(30, enemy.getDamage());
        assertEquals(100, enemy.getCoinReward());
        assertEquals(1, enemy.getSpeed());
    }

    @Test
    public void enemyDraw() {
        Enemy enemy = new Minion();
        Pane pane = new StackPane();
        enemy.drawEnemy(20, 21, pane);
        assertEquals(20, enemy.getPosX());
        assertEquals(21, enemy.getPosY());
    }
}
