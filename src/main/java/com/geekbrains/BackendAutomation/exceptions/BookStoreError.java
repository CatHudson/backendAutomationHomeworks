package com.geekbrains.BackendAutomation.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class BookStoreError {
    private int status;
    private String message;
    private Date timestamp;

    public BookStoreError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }

}
