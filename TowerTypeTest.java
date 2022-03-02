import com.peons.peonstd.FireTower;
import com.peons.peonstd.GameState;
import com.peons.peonstd.LightingTower;
import com.peons.peonstd.SnowTower;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TowerTypeTest extends ApplicationTest {
    private String difficulty1 = "Easy";
    private String difficulty2 = "Medium";
    private String difficulty3 = "Hard";
    private GameState gameState = new GameState(difficulty1);
    private GameState gameState2 = new GameState(difficulty2);
    private GameState gameState3 = new GameState(difficulty3);
    private SnowTower snowTower = new SnowTower(1, 2, gameState);
    private SnowTower snowTower2 = new SnowTower(1, 2, gameState2);
    private SnowTower snowTower3 = new SnowTower(1, 2, gameState3);
    private FireTower fireTower = new FireTower(1, 2, gameState);
    private FireTower fireTower2 = new FireTower(1, 2, gameState2);
    private FireTower fireTower3 = new FireTower(1, 2, gameState3);
    private LightingTower lightingTower = new LightingTower(1, 2, gameState);
    private LightingTower lightingTower2 = new LightingTower(1, 2, gameState2);
    private LightingTower lightingTower3 = new LightingTower(1, 2, gameState3);

    private String imagePathSnow = "src/main/resources/com/peons/peonstd/Katara.png";
    private String imagePathFire = "src/main/resources/com/peons/peonstd/aang.png";
    private String imagePathLighting = "src/main/resources/com/peons/peonstd/Toph.png";

    public TowerTypeTest() throws IOException {
    }

    @Test
    public  void testSnowCost() {
        
        int expectedCostS1 = 400;
        assertEquals(expectedCostS1, snowTower.getBuildCost());
        int expectedCostS2 = 500;
        assertEquals(expectedCostS2, snowTower2.getBuildCost());
        int expectedCostS3 = 600;
        assertEquals(expectedCostS3, snowTower3.getBuildCost());
        int expectedCostF1 = 800;
        assertEquals(expectedCostF1, fireTower.getBuildCost());
        int expectedCostF2 = 1000;
        assertEquals(expectedCostF2, fireTower2.getBuildCost());
        int expectedCostF3 = 1200;
        assertEquals(expectedCostF3, fireTower3.getBuildCost());
        int expectedCostL1 = 1000;
        assertEquals(expectedCostL1, lightingTower.getBuildCost());
        int expectedCostL2 = 1250;
        assertEquals(expectedCostL2, lightingTower2.getBuildCost());
        int expectedCostL3 = 1500;
        assertEquals(expectedCostL3, lightingTower3.getBuildCost());



    }
    @Test
    public void testImagePath() {
        assertEquals(imagePathSnow, snowTower.getImagePath());
        assertEquals(imagePathFire, fireTower.getImagePath());
        assertEquals(imagePathLighting, lightingTower.getImagePath());
    }
}

