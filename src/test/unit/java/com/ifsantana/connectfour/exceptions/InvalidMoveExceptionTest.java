package com.ifsantana.connectfour.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidMoveExceptionTest {
    @Test
    void testExceptionInitialization() {
        var exception = new InvalidMoveException("Exception  message.");
        assertEquals(exception.getMessage(), "Exception  message.");
    }
}
