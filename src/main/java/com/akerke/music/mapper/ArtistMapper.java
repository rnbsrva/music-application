package com.akerke.music.mapper;

import com.akerke.music.dto.SongResponseDTO;
import com.akerke.music.dto.request.ArtistDTO;
import com.akerke.music.dto.ArtistResponseDTO;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ArtistMapper {

    @Mapping(target = "songs", ignore = true)
    Artist toModel (ArtistDTO artistDTO);

    @Mapping(target = "songs", ignore = true)
    ArtistDTO toDTO (Artist artist);

    @Mapping(target = "songs", expression = "java(songResponseDTOS)")
    ArtistResponseDTO toArtistResponseDTO(Artist artist, List<SongResponseDTO> songResponseDTOS);

    @Mapping(target = "songs", expression = "java(songs)")
    Artist toModelFromArtistResponseDTO(ArtistResponseDTO artistResponseDTO, List<Song> songs);


}
