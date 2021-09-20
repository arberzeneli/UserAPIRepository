package com.arberzeneli.userapi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserApiExceptionHandler {

    @ExceptionHandler(value = {UserApiRequestException.class})
    public ResponseEntity<Object> handelUserApiRequestException(UserApiRequestException e){
       HttpStatus badRequest= HttpStatus.BAD_REQUEST;
       UserApiException userApiException= new UserApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
                );
    return  new ResponseEntity<>(userApiException,badRequest);
    }
}
