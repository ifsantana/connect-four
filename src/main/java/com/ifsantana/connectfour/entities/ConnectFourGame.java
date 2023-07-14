package com.ifsantana.connectfour.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectFourGame {
    private char[][] board;
    private Player currentPlayer;

    public ConnectFourGame() {
        this.setBoard(new char[6][7]);
        this.setCurrentPlayer(new Player('X'));
        startNewGame();
    }

    private void startNewGame() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public Player switchPlayer() {
        if(currentPlayer.getId() == 'X')
            currentPlayer.setId('0');
        else {
            currentPlayer.setId('X');
        }
        return currentPlayer;
    }
}
