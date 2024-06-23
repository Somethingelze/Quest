package com.textAdventure.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testInitialGameState() {
        Game game = new Game();
        assertEquals("Добро пожаловать в текстовый квест!", game.getMessage());
        assertFalse(game.isFinished());
    }

    @Test
    public void testNextStep() {
        Game game = new Game();
        game.nextStep("left");
        assertEquals("Вы пошли налево и встретили дракона!", game.getMessage());
        assertFalse(game.isFinished());

        game.nextStep("fight");
        assertEquals("Вы победили дракона!", game.getMessage());
        assertTrue(game.isFinished());
    }
}
