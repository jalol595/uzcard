package com.example.uzcard.controller;



import com.example.uzcard.exseptions.AlreadyExist;
import com.example.uzcard.exseptions.BadRequestException;
import com.example.uzcard.exseptions.ItemNotFoundEseption;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExseptionHanlerController {


    @ExceptionHandler({BadRequestException.class, ItemNotFoundEseption.class,
            AlreadyExist.class, UsernameNotFoundException.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
