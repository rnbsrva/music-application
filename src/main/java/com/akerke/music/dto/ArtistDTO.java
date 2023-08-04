package com.akerke.music.dto;


import java.util.List;

public record ArtistDTO(
        Long id,
         String name,
         String surname,
         String country,
         Integer yearsActive,
         List<SongDTO> songs
) {
}
