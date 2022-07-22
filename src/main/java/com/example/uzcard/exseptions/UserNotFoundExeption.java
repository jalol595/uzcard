package com.example.uzcard.exseptions;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
