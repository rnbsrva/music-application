package com.akerke.music.exception.handler;

import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.exception.InvalidRequestException;
import com.akerke.music.exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    ProblemDetail handleArtistNotFoundException(ArtistNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Artist Not Found");
        return problemDetail;
    }
    // FIXME: 8/5/2023    methooooooooooooooooood


    @ExceptionHandler(SongNotFoundException.class)
    ProblemDetail handleSongNotFoundException(SongNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Song Not Found");
        return problemDetail;
    }

    @ExceptionHandler(InvalidRequestException.class)
    ProblemDetail handleInvalidRequestException(InvalidRequestException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Invalid Request Exception");
        return problemDetail;
    }

}
