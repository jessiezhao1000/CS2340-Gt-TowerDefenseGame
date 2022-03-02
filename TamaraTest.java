import com.peons.peonstd.GameState;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TamaraTest extends ApplicationTest {

    private GameState testGameStack = new GameState("Easy");

    @Test
    public void testMoney() {
        int monumentHealthTest = 2000;
        if (Objects.equals(testGameStack.getDifficulty(), "Easy")) {
            assertEquals(monumentHealthTest, testGameStack.getMoney());
        }
        monumentHealthTest = 1500;
        if (Objects.equals(testGameStack.getDifficulty(), "Medium")) {
            assertEquals(monumentHealthTest, testGameStack.getMoney());
        }
        monumentHealthTest = 1000;
        if (monumentHealthTest == testGameStack.getMoney()) {
            assertEquals(monumentHealthTest, testGameStack.getMoney());
        }
    }
}
