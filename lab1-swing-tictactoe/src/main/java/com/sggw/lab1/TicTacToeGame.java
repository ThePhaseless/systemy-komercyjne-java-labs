package com.sggw.lab1;

import java.util.Arrays;

public class TicTacToeGame {
    private static final int[][] WINNING_LINES = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private final char[] board = new char[9];
    private char currentPlayer;
    private char winner;
    private boolean finished;

    public TicTacToeGame() {
        reset();
    }

    public boolean makeMove(int index) {
        if (finished || index < 0 || index >= board.length || board[index] != ' ') {
            return false;
        }

        board[index] = currentPlayer;
        updateState();

        if (!finished) {
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getCell(int index) {
        return board[index];
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean hasWinner() {
        return winner != ' ';
    }

    public char getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return finished && winner == ' ';
    }

    public String getStatusText() {
        if (hasWinner()) {
            return "Winner: " + winner;
        }
        if (isDraw()) {
            return "Draw. Click restart to play again.";
        }
        return "Turn: " + currentPlayer;
    }

    public void reset() {
        Arrays.fill(board, ' ');
        currentPlayer = 'X';
        winner = ' ';
        finished = false;
    }

    private void updateState() {
        for (int[] line : WINNING_LINES) {
            char first = board[line[0]];
            if (first != ' ' && first == board[line[1]] && first == board[line[2]]) {
                winner = first;
                finished = true;
                return;
            }
        }

        finished = true;
        for (char cell : board) {
            if (cell == ' ') {
                finished = false;
                return;
            }
        }
    }
}
