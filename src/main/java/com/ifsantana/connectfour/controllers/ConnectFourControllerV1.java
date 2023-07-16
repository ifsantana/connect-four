package com.ifsantana.connectfour.controllers;

import com.ifsantana.connectfour.exceptions.FullColumnException;
import com.ifsantana.connectfour.exceptions.GameNotStartedException;
import com.ifsantana.connectfour.exceptions.InvalidMoveException;
import com.ifsantana.connectfour.services.ConnectFourService;
import com.ifsantana.connectfour.services.ConnectFourServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(summary = "This endpoint starts a new game or restarts a existing one.")
    @PostMapping
    public ResponseEntity<String> newGame() {
        var game = connectFourService.newGame();

        if(Objects.nonNull(game))
            return new ResponseEntity<>(connectFourService.getBoardState(), HttpStatus.CREATED);

        return ResponseEntity.unprocessableEntity().build();
    }

    @Operation(summary = "This endpoint returns the current board state.")
    @GetMapping
    public ResponseEntity<String> getBoard() {
        return ResponseEntity.ok(connectFourService.getBoardState());
    }

    @Operation(summary = "This endpoint allows an player to make a move and returns the board state after the move.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Valid move. Waiting for the next player move."),
            @ApiResponse(responseCode = "409", description = "Invalid Move. Column full!",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FullColumnException.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid Move. Invalid move!",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InvalidMoveException.class))}
            ),
            @ApiResponse(responseCode = "404", description = "No matches started. Please start a new game before to start to play.",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GameNotStartedException.class))}
            )
    })
    @PatchMapping("/make-move/{column}")
    public ResponseEntity<String> makeMove(@PathVariable int column) {
        return connectFourService.makeMove(column);
    }
}
