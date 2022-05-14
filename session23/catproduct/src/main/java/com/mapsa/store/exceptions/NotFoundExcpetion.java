package com.mapsa.store.exceptions;

public class NotFoundExcpetion extends RuntimeException {
    public NotFoundExcpetion() {


    }

    public NotFoundExcpetion(String message) {
        super(message);
    }
}
