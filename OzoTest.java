package com.peons.peonstd;

import com.peons.peonstd.Azula;
import com.peons.peonstd.Enemy;
import com.peons.peonstd.Zuko;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class OzoTest {
    @Test
    public void OzoDead() throws IOException {
        Enemy enemy = new FireLordOzo();
        enemy.drawEnemy(0, 0, new Pane());
        enemy.damageHealth(100000);
        assertTrue(enemy.isDead());
    }

    @Test
    public void OzoValues() throws IOException {
        Enemy enemy = new FireLordOzo();
        enemy.drawEnemy(0, 0, new Pane());
        assertEquals(70, enemy.getDamage());
        assertEquals(400, enemy.getCoinReward());
        assertEquals(1, enemy.getSpeed());
    }
}