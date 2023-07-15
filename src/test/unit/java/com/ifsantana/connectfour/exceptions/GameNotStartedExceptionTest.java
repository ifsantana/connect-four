package com.ifsantana.connectfour.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GameNotStartedExceptionTest {
    @Test
    void testExceptionInitialization() {
        var exception = new GameNotStartedException("Exception  message.");
        assertEquals(exception.getMessage(), "Exception  message.");
    }
}
