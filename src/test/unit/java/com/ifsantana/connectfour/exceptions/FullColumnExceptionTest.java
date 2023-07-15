package com.ifsantana.connectfour.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FullColumnExceptionTest {
  @Test
  void testExceptionInitialization() {
    var exception = new FullColumnException("Exception  message.");
    assertEquals(exception.getMessage(), "Exception  message.");
  }
}
