package com.bookmap.exception;

public class ReadDataException extends RuntimeException {

    public ReadDataException(String message) {
        super(message);
    }

    public ReadDataException(String message, Throwable cause) {
        super(message, cause);
    }
}