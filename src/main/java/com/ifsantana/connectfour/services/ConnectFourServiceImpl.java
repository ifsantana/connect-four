package com.ifsantana.connectfour.services;

import com.ifsantana.connectfour.entities.ConnectFourGame;
import com.ifsantana.connectfour.exceptions.GameNotStartedException;
import com.ifsantana.connectfour.repositories.ConnectFourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConnectFourServiceImpl implements ConnectFourService {
    private final ConnectFourRepository connectFourRepository;

    @Autowired
    public ConnectFourServiceImpl(ConnectFourRepository connectFourRepository) {
        this.connectFourRepository = connectFourRepository;
    }

    @Override
    public ConnectFourGame newGame() {
        return connectFourRepository.newGame();
    }

    @Override
    public ResponseEntity<String> makeMove(int column) {
        var game = connectFourRepository.getGame();

        if(Objects.isNull(game))
            throw new GameNotStartedException("No matches started. Please start a new game before to start to play.");

        game.executeMove(column);

        if (checkWin(game)) {
            return ResponseEntity.ok(
                "Congratulations! Player "
                    + game.getCurrentPlayer().getId()
                    + " wins!"
                    + System.getProperty("line.separator")
                    + System.getProperty("line.separator")
                    + getBoardState());
        } else {
            return ResponseEntity.ok(
                "Move made. It's now Player "
                    + game.getCurrentPlayer().getId()
                    + " 's turn."
                    + System.getProperty("line.separator")
                    + System.getProperty("line.separator")
                    + getBoardState());
        }
    }

    @Override
    public boolean checkWin(ConnectFourGame game) {

        if(game.checkForAWinHorizontally())
            return true;

        if(game.checkForAWinVertically())
            return true;

        if(game.checkForAWinTopLeftBottomRight())
            return true;

        return game.checkForAWinBottomLeftTopRight();
    }

    @Override
    public String getBoardState() {
        StringBuilder stringBuilder = new StringBuilder();
        var game = connectFourRepository.getGame();
        var board = game.getBoard();

        for (int row = 0; row < 6; row++) {
            stringBuilder.append("|");
            for (int col = 0; col < 7; col++) {
                stringBuilder.append(board[row][col]).append("|");
            }
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
