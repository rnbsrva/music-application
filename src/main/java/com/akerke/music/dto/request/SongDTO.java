package com.akerke.music.dto.request;

import com.akerke.music.constants.Genre;
import com.akerke.music.model.Artist;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.time.Year;

public record SongDTO(
        @NotBlank
         String title,
         @NotNull @Positive
         Long duration,
         @NotNull @PastOrPresent
         Year releaseYear,
         Genre genre,
         @NotNull @Positive
         Long artistId
) {
}
