package ru.geekbrains.autumnmarket.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHangler {

    @ExceptionHandler
    public ResponseEntity<?> cathExeption(ResourceNotFoundExeption e){
        return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<?> cathValidationExeption(DataValidationExeption e){
        return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
