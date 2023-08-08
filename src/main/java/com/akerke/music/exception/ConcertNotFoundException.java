package com.akerke.music.exception;

public class ConcertNotFoundException extends RuntimeException {

    public ConcertNotFoundException(Long id) {
        super("Concert with id %s not found".formatted(id.toString()));
    }

}
