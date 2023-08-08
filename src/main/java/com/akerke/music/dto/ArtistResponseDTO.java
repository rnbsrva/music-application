package com.akerke.music.dto;

import com.akerke.music.dto.request.SongDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record ArtistResponseDTO(
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank(message = "country can not be blank")
        String country,
        @NotNull @PositiveOrZero
        Integer yearsActive,
         List<SongResponseDTO> songs

) {
}
