import com.peons.peonstd.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DanielTest {

    private GameState testState = new GameState("Easy");

    @Test
    public void testMonumentHealth() {
        // Testing easy difficulty health value
        assertEquals(180, testState.getMonumentHealth());
        // Testing medium difficulty health value
        GameState testMedium = new GameState("Medium");
        assertEquals(150, testMedium.getMonumentHealth());
        // Testing hard difficulty health value
        GameState testHard = new GameState("Hard");
        assertEquals(100, testHard.getMonumentHealth());
    }
}