package com.ifsantana.connectfour.services;

import com.ifsantana.connectfour.entities.ConnectFourGame;
import org.springframework.http.ResponseEntity;

public interface ConnectFourService {
  ConnectFourGame newGame();
  ResponseEntity<String> makeMove(int column);
  boolean checkWin(ConnectFourGame game);
  String getBoardState();
}
