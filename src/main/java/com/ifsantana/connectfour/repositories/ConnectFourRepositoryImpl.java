package com.ifsantana.connectfour.repositories;

import com.ifsantana.connectfour.entities.ConnectFourGame;
import org.springframework.stereotype.Service;

@Service
public class ConnectFourRepositoryImpl implements ConnectFourRepository {
    private ConnectFourGame game;

    @Override
    public ConnectFourGame newGame() {
        game = new ConnectFourGame();
        return game;
    }

    @Override
    public ConnectFourGame getGame() {
        return game;
    }
}
