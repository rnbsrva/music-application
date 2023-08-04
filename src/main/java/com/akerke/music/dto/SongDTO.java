package com.akerke.music.dto;

import com.akerke.music.constants.Genre;
import com.akerke.music.model.Artist;
import jakarta.persistence.ManyToOne;

import java.time.Year;

public record SongDTO(
         String title,
         Long duration,
         Year releaseYear,
         Genre genre,
         Long artistId
) {
}
