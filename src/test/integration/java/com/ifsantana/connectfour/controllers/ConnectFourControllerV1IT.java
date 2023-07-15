package com.ifsantana.connectfour.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ConnectFourControllerV1IT {
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() throws Exception {
    // Initialize or reset any necessary test data
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/connect-four"));
  }

  @Test
  void testNewGame() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/connect-four"))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  void testGetBoard() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/connect-four"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
  }

  @Test
  public void testMakeMove_ValidMove() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/connect-four/make-move/3"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Move made. It's now Player 0 's turn.\n"
            + "\n"
            + "| | | | | | | |\n"
            + "| | | | | | | |\n"
            + "| | | | | | | |\n"
            + "| | | | | | | |\n"
            + "| | | | | | | |\n"
            + "| | | |X| | | |\n"));
  }

  @Test
  public void testMakeMove_InvalidMove() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/connect-four/make-move/10"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
