package com.ifsantana.connectfour.entities;

import com.ifsantana.connectfour.exceptions.FullColumnException;
import com.ifsantana.connectfour.exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectFourGame {
    private static final Character NUMBER_OF_ROWS = 6;
    private static final Character NUMBER_OF_COLUMNS = 7;
    private char[][] board;
    private Player currentPlayer;

    public ConnectFourGame() {
        this.setBoard(new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]);
        this.setCurrentPlayer(new Player('X'));
        startNewGame();
    }

    private void startNewGame() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void switchPlayer() {
        if(currentPlayer.getId() == 'X')
            currentPlayer.setId('0');
        else {
            currentPlayer.setId('X');
        }
    }

    public boolean checkForAWinBottomLeftTopRight() {
        for (int row = 3; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] != ' ' &&
                    board[row][col] == board[row - 1][col + 1] &&
                    board[row][col] == board[row - 2][col + 2] &&
                    board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        return  false;
    }

    public boolean checkForAWinTopLeftBottomRight() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] != ' ' &&
                    board[row][col] == board[row + 1][col + 1] &&
                    board[row][col] == board[row + 2][col + 2] &&
                    board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForAWinVertically() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                if (board[row][col] != ' ' &&
                    board[row][col] == board[row + 1][col] &&
                    board[row][col] == board[row + 2][col] &&
                    board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForAWinHorizontally() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] != ' ' &&
                    board[row][col] == board[row][col + 1] &&
                    board[row][col] == board[row][col + 2] &&
                    board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public ConnectFourGame executeMove(int column) {
        if (column < 0 || column >= NUMBER_OF_COLUMNS || board[0][column] != ' ') {
            throw new InvalidMoveException("Invalid move");
        }

        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = currentPlayer.getId();
                switchPlayer();
                return this;
            }
        }

        throw new FullColumnException("Column is full");
    }
}
