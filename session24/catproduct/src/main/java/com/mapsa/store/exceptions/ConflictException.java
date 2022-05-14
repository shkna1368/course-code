package com.mapsa.store.exceptions;

public class ConflictException extends RuntimeException{

    public ConflictException() {
        super();
    }

    public ConflictException(String message) {
        super(message);
    }
}
