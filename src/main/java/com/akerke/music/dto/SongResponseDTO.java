package com.akerke.music.dto;

import com.akerke.music.constants.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.Year;

public record SongResponseDTO (
        Long id,
        @NotBlank
        String title,
        @NotNull @Positive
        Long duration,
        @NotNull @PastOrPresent
        Year releaseYear,
        Genre genre,
        @NotNull
        Long artistId
){
}
