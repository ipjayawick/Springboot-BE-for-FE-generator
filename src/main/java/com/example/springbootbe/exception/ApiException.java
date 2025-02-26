package com.example.springbootbe.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private  final HttpStatus httpStatus;

}
