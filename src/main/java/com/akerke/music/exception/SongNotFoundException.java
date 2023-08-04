package com.akerke.music.exception;

public class SongNotFoundException extends RuntimeException{

    public SongNotFoundException(Long id) {
        super("Song with id %s not found".formatted(id.toString()));
    }
}
