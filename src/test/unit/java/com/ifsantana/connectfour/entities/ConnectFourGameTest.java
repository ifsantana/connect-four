package com.ifsantana.connectfour.entities;

import static org.junit.jupiter.api.Assertions.*;

import com.ifsantana.connectfour.exceptions.InvalidMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectFourGameTest {
    private ConnectFourGame game;

    @BeforeEach
    public void setUp() {
        game = new ConnectFourGame();
    }

    @Test
    void testInitialBoard() {
        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    void testInitialPlayer() {
        assertEquals('X' , game.getCurrentPlayer().getId());
    }

    @Test
    void testSwitchingPlayer() {
        assertEquals('X' , game.getCurrentPlayer().getId());
        game.switchPlayer();
        assertEquals('0' , game.getCurrentPlayer().getId());
    }

    @Test
    void testMakeMove_ValidMove() {
        assertNotNull(game.executeMove(3));
        assertEquals('X', game.getBoard()[5][3]);
    }

    @Test
    void testMakeMove_InvalidMove() {
        assertThrows(InvalidMoveException.class, () -> game.executeMove(10));
    }
}
