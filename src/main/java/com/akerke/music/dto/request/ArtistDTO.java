package com.akerke.music.dto.request;


import jakarta.validation.constraints.*;

import java.util.List;

public record ArtistDTO(
         @NotBlank
         String name,
        @NotBlank
         String surname,
        @NotBlank(message = "country can not be blanK")
         String country,
        @NotNull
         Integer yearsActive,
         List<SongDTO> songs
) {
}
