package com.ifsantana.connectfour.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FullColumnException extends RuntimeException {
    public FullColumnException(String message) {
        super(message);
    }
}
