import com.peons.peonstd.Azula;
import com.peons.peonstd.Enemy;
import com.peons.peonstd.Zuko;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
public class AzulaandZukoTest {

    @Test
    public void azulaInit() throws IOException {
        Enemy enemy = new Azula();
        enemy.drawEnemy(0, 0, new Pane());
        enemy.damageHealth(100000);
        assertTrue(enemy.isDead());
        assertEquals(50, enemy.getDamage());
        assertEquals(200, enemy.getCoinReward());
        assertEquals(2, enemy.getSpeed());
    }

    @Test
    public void zukoInit() throws IOException {
        Enemy enemy = new Zuko();
        enemy.drawEnemy(0, 0, new Pane());
        enemy.damageHealth(100000);
        assertTrue(enemy.isDead());
        assertEquals(100, enemy.getDamage());
        assertEquals(500, enemy.getCoinReward());
        assertEquals(2, enemy.getSpeed());
    }
}
