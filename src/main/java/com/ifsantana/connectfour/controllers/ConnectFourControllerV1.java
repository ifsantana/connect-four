package com.ifsantana.connectfour.controllers;

import com.ifsantana.connectfour.services.ConnectFourService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/connect-four")
public class ConnectFourControllerV1 {
    private final ConnectFourService connectFourService;

    @Autowired
    public ConnectFourControllerV1(ConnectFourService connectFourService) {
        this.connectFourService = connectFourService;
    }

    @Operation(summary = "This endpoint creates a new game.")
    @PostMapping
    public ResponseEntity<String> newGame() {
        var game = connectFourService.newGame();
        if(Objects.nonNull(game))
            return new ResponseEntity<>(connectFourService.getBoardState(), HttpStatus.CREATED);

        return ResponseEntity.unprocessableEntity().build();
    }

    @Operation(summary = "This endpoint returns the current game status.")
    @GetMapping
    public ResponseEntity getBoard() {
        return ResponseEntity.ok(connectFourService.getBoardState());
    }

    @Operation(summary = "This endpoint allows an player to make a move.")
    @PatchMapping("/make-move/{column}")
    public ResponseEntity<String> makeMove(@PathVariable int column) {
        var game = connectFourService.makeMove(column);

        if (Objects.nonNull(game)) {
            if (connectFourService.checkWin()) {
                return ResponseEntity.ok("Congratulations! Player " + game.getCurrentPlayer().getId() + " wins!\n" + connectFourService.getBoardState());
            } else {
                game.switchPlayer();
                return ResponseEntity.ok("Move made. It's now Player " + game.getCurrentPlayer().getId() + "'s turn. \n" + connectFourService.getBoardState());
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid move.");
        }
    }
}
