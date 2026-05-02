package com.sggw.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {
    @Test
    void startsWithEmptyBoardAndPlayerX() {
        TicTacToeGame game = new TicTacToeGame();

        assertEquals('X', game.getCurrentPlayer());
        for (int i = 0; i < 9; i++) {
            assertEquals(' ', game.getCell(i));
        }
        assertFalse(game.isFinished());
    }

    @Test
    void detectsWinner() {
        TicTacToeGame game = new TicTacToeGame();

        assertTrue(game.makeMove(0));
        assertTrue(game.makeMove(3));
        assertTrue(game.makeMove(1));
        assertTrue(game.makeMove(4));
        assertTrue(game.makeMove(2));

        assertTrue(game.hasWinner());
        assertEquals('X', game.getWinner());
        assertTrue(game.isFinished());
    }

    @Test
    void detectsDraw() {
        TicTacToeGame game = new TicTacToeGame();
        int[] moves = {0, 1, 2, 4, 3, 5, 7, 6, 8};

        for (int move : moves) {
            assertTrue(game.makeMove(move));
        }

        assertTrue(game.isDraw());
        assertTrue(game.isFinished());
        assertEquals(' ', game.getWinner());
    }

    @Test
    void rejectsInvalidMove() {
        TicTacToeGame game = new TicTacToeGame();

        assertTrue(game.makeMove(0));
        assertFalse(game.makeMove(0));
        assertEquals('O', game.getCurrentPlayer());
        assertEquals('X', game.getCell(0));
    }

    @Test
    void resetsGame() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0);
        game.makeMove(1);
        game.reset();

        assertEquals('X', game.getCurrentPlayer());
        assertFalse(game.isFinished());
        assertFalse(game.hasWinner());
        assertFalse(game.isDraw());
        for (int i = 0; i < 9; i++) {
            assertEquals(' ', game.getCell(i));
        }
    }
}
