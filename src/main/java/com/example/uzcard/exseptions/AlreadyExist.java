package com.example.uzcard.exseptions;

public class AlreadyExist extends RuntimeException {

    public AlreadyExist(String message) {
        super(message);
    }
}
