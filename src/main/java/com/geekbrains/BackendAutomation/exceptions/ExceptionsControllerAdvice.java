package com.geekbrains.BackendAutomation.exceptions;

import com.geekbrains.BackendAutomation.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        BookStoreError bookStoreError = new BookStoreError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(bookStoreError, HttpStatus.NOT_FOUND);
    }
}
