package com.akerke.music.service;

import com.akerke.music.dto.ArtistResponseDTO;
import com.akerke.music.dto.request.ArtistDTO;

import java.util.List;
import java.util.Map;

public interface ArtistService {

    List<ArtistResponseDTO> getAll();

    ArtistResponseDTO getById(Long id);

    ArtistResponseDTO save (ArtistDTO artistDTO);

    boolean delete(Long id);

    ArtistResponseDTO update(Long id, ArtistDTO artistDTO);

    ArtistResponseDTO updatePartially(Long id, Map<String, Object> updatedFields);
}
