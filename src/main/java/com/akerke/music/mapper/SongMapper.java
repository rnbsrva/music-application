package com.akerke.music.mapper;

import com.akerke.music.dto.SongResponseDTO;
import com.akerke.music.dto.request.SongDTO;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(imports = Artist.class, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SongMapper {

    @Mapping(target = "artist", ignore = true)
    Song toModel (SongDTO songDTO, Artist artist);

    @Mapping(target = "artistId", expression = "java(song.getArtist().getId())")
    SongDTO toDTO (Song song);

    @Mapping(target="artistId", expression = "java(song.getArtist().getId())")
    SongResponseDTO toSongResponseDTO(Song song);

    @Mapping(target = "artist", expression = "java(artist)")
    @Mapping(target = "id", expression = "java(songResponseDTO.id())")
    Song toModelFromResponseDTO (SongResponseDTO songResponseDTO,  Artist artist);

    void update (SongDTO songDTO, @MappingTarget Song song);

}
