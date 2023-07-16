package com.ifsantana.connectfour.repositories;

import com.ifsantana.connectfour.entities.ConnectFourGame;

public interface ConnectFourRepository {
  ConnectFourGame newGame();
  ConnectFourGame getGame();
}
