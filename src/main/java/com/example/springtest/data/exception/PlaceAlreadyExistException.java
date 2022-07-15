package com.example.springtest.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Place already exists")  // 400
public class PlaceAlreadyExistException extends RuntimeException {

}
