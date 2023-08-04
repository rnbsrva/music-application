package com.akerke.music.service;

import com.akerke.music.dto.ArtistDTO;
import com.akerke.music.model.Artist;

import java.util.List;
import java.util.Map;

public interface ArtistService {

    List<ArtistDTO> getAll();

    Artist getById(Long id);

    Artist save (ArtistDTO artistDTO);

    boolean delete(Long id);

    Artist update(Long id, ArtistDTO artistDTO);

    Artist updatePartially(Long id, Map<String, Object> updatedFields);
}
