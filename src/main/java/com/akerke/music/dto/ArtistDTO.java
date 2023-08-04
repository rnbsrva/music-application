package com.akerke.music.dto;


import jakarta.validation.constraints.*;

import java.util.List;

public record ArtistDTO(
         @NotBlank @Max(value = 25) @Min(value = 3)
         String name,
        @NotBlank @Max(value = 25) @Min(value = 3)
         String surname,
        @NotBlank(message = "country can not be blanK") @NotEmpty @Max(value = 50) @Min(value = 2)
         String country,
        @NotNull
         Integer yearsActive,
         List<SongDTO> songs
) {
}
