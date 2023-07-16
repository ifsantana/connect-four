package com.ifsantana.connectfour.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ifsantana.connectfour.repositories.ConnectFourRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectFourServiceTest {
  private ConnectFourService connectFourService;

  @BeforeEach
  void setup() {
    connectFourService = new ConnectFourServiceImpl(new ConnectFourRepositoryImpl());
  }

  @Test
  void test_GetBoardState() {
    var game = connectFourService.newGame();

    assertEquals("| | | | | | | |\n"
        + "| | | | | | | |\n"
        + "| | | | | | | |\n"
        + "| | | | | | | |\n"
        + "| | | | | | | |\n"
        + "| | | | | | | |\n", connectFourService.getBoardState());
  }

  @Test
  void testCheckWin_NoWin() {
    var game = connectFourService.newGame();
    assertFalse(connectFourService.checkWin(game));
  }

  @Test
  void testCheckWin_HorizontalWin() {
    var game = connectFourService.newGame();
    game.executeMove(0);
    game.executeMove(0);
    game.executeMove(1);
    game.executeMove(1);
    game.executeMove(2);
    game.executeMove(2);
    game.executeMove(3);
    game.executeMove(3);
    assertTrue(connectFourService.checkWin(game));
  }

  @Test
  void testCheckWin_VerticalWin() {
    var game = connectFourService.newGame();
    game.executeMove(0);
    game.executeMove(1);
    game.executeMove(0);
    game.executeMove(1);
    game.executeMove(0);
    game.executeMove(1);
    game.executeMove(0);
    game.executeMove(1);
    assertTrue(connectFourService.checkWin(game));
  }

  @Test
  void testCheckWin_DiagonalWin() {
    var game = connectFourService.newGame();
    game.executeMove(0);
    game.executeMove(1);
    game.executeMove(1);
    game.executeMove(2);
    game.executeMove(2);
    game.executeMove(3);
    game.executeMove(4);
    game.executeMove(3);
    game.executeMove(3);
    game.executeMove(3);
    game.executeMove(4);
    game.executeMove(5);
    game.executeMove(4);
    game.executeMove(5);
    game.executeMove(4);
    assertTrue(connectFourService.checkWin(game));
  }
}
