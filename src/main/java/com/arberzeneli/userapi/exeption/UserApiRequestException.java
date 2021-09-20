package com.arberzeneli.userapi.exeption;

public class UserApiRequestException extends RuntimeException{

    public UserApiRequestException(String message) {
        super(message);
    }

    public UserApiRequestException(String message, Throwable cause) {
        super(message, cause);

    }
}
