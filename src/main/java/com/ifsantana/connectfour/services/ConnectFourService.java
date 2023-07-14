package com.ifsantana.connectfour.services;

import com.ifsantana.connectfour.entities.ConnectFourGame;
import com.ifsantana.connectfour.exceptions.FullColumnException;
import com.ifsantana.connectfour.exceptions.InvalidMoveException;
import com.ifsantana.connectfour.repositories.ConnectFourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectFourService {
    private final ConnectFourRepository connectFourRepository;

    @Autowired
    public ConnectFourService(ConnectFourRepository connectFourRepository) {
        this.connectFourRepository = connectFourRepository;
    }

    public ConnectFourGame newGame() {
        return connectFourRepository.newGame();
    }

    public ConnectFourGame makeMove(int column) {
        ConnectFourGame game = connectFourRepository.getGame();
        var board = game.getBoard();

        if (column < 0 || column >= 7 || board[0][column] != ' ') {
            throw new InvalidMoveException("Invalid move");
        }

        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = game.getCurrentPlayer().getId();
                return game;
            }
        }

        throw new FullColumnException("Column is full");
    }

    public boolean checkWin() {
        ConnectFourGame game = connectFourRepository.getGame();
        var board = game.getBoard();

        // Check for a win horizontally
        if(checkForAWinHorizontally(board))
            return true;

        // Check for a win vertically
        if(checkForAWinVertically(board))
            return true;


        // Check for a win diagonally (top-left to bottom-right)
        if(checkForAWinTopLeftBottomRight(board))
            return true;

        // Check for a win diagonally (bottom-left to top-right)
        return checkForAWinBottomLeftTopRight(board);// No win
    }

    private boolean checkForAWinBottomLeftTopRight(char[][] board) {
        for (int row = 3; row < 6; row++) {
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

    private boolean checkForAWinTopLeftBottomRight(char[][] board) {
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

    private boolean checkForAWinVertically(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 7; col++) {
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

    private boolean checkForAWinHorizontally(char[][] board) {
        for (int row = 0; row < 6; row++) {
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

    public String getBoardState() {
        StringBuffer stringBuffer = new StringBuffer();
        var game = connectFourRepository.getGame();
        var board = game.getBoard();

        for (int row = 0; row < 6; row++) {
            stringBuffer.append("|");
            for (int col = 0; col < 7; col++) {
                stringBuffer.append(board[row][col]).append("|");
            }
            stringBuffer.append(System.getProperty("line.separator"));
        }
        return stringBuffer.toString();
    }
}
