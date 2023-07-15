package com.ifsantana.connectfour.repositories;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ConnectFourRepositoryIT {
    @Autowired
    private ConnectFourRepository connectFourRepository;

    @Test
    void test_NewGame() {
      char[][] expectedBoard = {
          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
          {' ', ' ', ' ', ' ', ' ', ' ', ' '}
      };
      var newGame = connectFourRepository.newGame();
      assertArrayEquals(newGame.getBoard(), expectedBoard);
      assertEquals(newGame.getCurrentPlayer().getId(), 'X');
    }

  @Test
  void test_GetGame() {
    char[][] expectedBoard = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };
    connectFourRepository.newGame();
    var game = connectFourRepository.getGame();
    assertArrayEquals(game.getBoard(), expectedBoard);
    assertEquals(game.getCurrentPlayer().getId(), 'X');
  }
}
