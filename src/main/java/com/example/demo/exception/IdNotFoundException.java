package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {
    private int id;

    public IdNotFoundException(int id) {
        super(String.format("Not found with id : '%d'", id));
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
