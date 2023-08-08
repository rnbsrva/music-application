package com.akerke.music.service;

import com.akerke.music.dto.SongResponseDTO;
import com.akerke.music.dto.request.SongDTO;

import java.util.List;

public interface SongService {

    List<SongResponseDTO> getAll();

    SongResponseDTO getById(Long id);

    SongResponseDTO save(SongDTO songDTO);

    boolean delete(Long id);

    SongResponseDTO update(Long id, SongDTO songDTO);

    SongResponseDTO updatePartially(Long id, SongDTO songDTO);
}
