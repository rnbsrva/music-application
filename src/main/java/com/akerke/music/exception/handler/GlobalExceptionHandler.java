package com.akerke.music.exception.handler;

import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.exception.ConcertNotFoundException;
import com.akerke.music.exception.InvalidRequestException;
import com.akerke.music.exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.function.BiFunction;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    ProblemDetail handleArtistNotFoundException(ArtistNotFoundException e) {
        return withDetails.apply(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SongNotFoundException.class)
    ProblemDetail handleSongNotFoundException(SongNotFoundException e) {
        return withDetails.apply(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConcertNotFoundException.class)
    ProblemDetail handleConcertNotFoundException(SongNotFoundException e) {
        return withDetails.apply(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    ProblemDetail handleInvalidRequestException(InvalidRequestException e) {
        return  withDetails.apply(e, HttpStatus.BAD_REQUEST);
    }

    private final BiFunction<RuntimeException, HttpStatus, ProblemDetail> withDetails =
            (e, status) ->
                    ProblemDetail.forStatusAndDetail(status, e.getMessage());

}
