package com.akerke.music.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;
import java.util.List;

public record ConcertDTO(
         @NotBlank
         String title,
         @NotNull @PastOrPresent
         Date date,
         @NotEmpty
         List<Long> artists
) {
}
