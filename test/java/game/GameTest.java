package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test
    void testIsWinSituation() {
        assertTrue(game.isWinSituation(0, 0));
        assertFalse(game.isWinSituation(10, 0));
        assertFalse(game.isWinSituation(10, 10));
        assertFalse(game.isWinSituation(0, 10));
        assertFalse(game.isWinSituation(10, -10));
        assertFalse(game.isWinSituation(-10, 0));
        assertFalse(game.isWinSituation(-10, 100));
    }
}