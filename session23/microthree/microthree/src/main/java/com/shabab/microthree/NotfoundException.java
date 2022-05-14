package com.shabab.microthree;

public class NotfoundException extends RuntimeException{
    public NotfoundException() {
        super();
    }

    public NotfoundException(String message) {
        super(message);
    }
}
