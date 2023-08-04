package com.akerke.music.service;

import com.akerke.music.dto.SongDTO;
import com.akerke.music.model.Song;

import java.util.List;
import java.util.Map;

public interface SongService {

    List<Song> getAll();

    Song getById(Long id);

    Song save(SongDTO songDTO);

    boolean delete(Long id);

    Song update(Long id, SongDTO songDTO);

    Song updatePartially(Long id, Map<String, Object> updatedFields);
}
