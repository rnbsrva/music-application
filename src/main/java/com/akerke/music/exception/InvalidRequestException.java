package com.akerke.music.exception;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(Class<?> c, String error) {
        super("Wrong request for %s. Error: %s, ".formatted(c.getSimpleName(), error));
    }

}
