package com.akerke.music.exception;

import org.springframework.web.ErrorResponseException;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(Long id) {
        super("Artist with id %s not found".formatted(id.toString()));
    }

}
