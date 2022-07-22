package com.example.uzcard.exseptions;

public class ItemNotFoundEseption extends RuntimeException {

    public ItemNotFoundEseption(String message) {
        super(message);
    }
}
