package com.akerke.music.mapper;

import com.akerke.music.dto.ConcertDTO;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Concert;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ConcertMapper {

    @Mapping(target = "artists", expression = "java(artists)")
    Concert toModel (ConcertDTO concertDTO, List<Artist> artists);

    @Mapping(target = "artists", ignore = true)
    ConcertDTO toDTO (Concert concert);

    @Mapping(target = "artists", ignore = true)
    void update (@MappingTarget Concert concert, ConcertDTO concertDTO);
}
