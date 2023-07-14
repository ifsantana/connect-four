package com.ifsantana.connectfour.repositories;

import com.ifsantana.connectfour.entities.ConnectFourGame;
import org.springframework.stereotype.Service;

@Service
public class ConnectFourRepository {
    private ConnectFourGame game;

    public ConnectFourGame newGame() {
        game = new ConnectFourGame();
        return game;
    }

    public ConnectFourGame getGame() {
        return game;
    }
}
