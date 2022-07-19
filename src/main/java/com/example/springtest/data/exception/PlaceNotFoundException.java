package com.example.springtest.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Location")  // 404
public class PlaceNotFoundException extends RuntimeException {

}
