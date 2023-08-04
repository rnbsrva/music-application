package com.akerke.music.service.impl;

import com.akerke.music.constants.Genre;
import com.akerke.music.dto.SongDTO;
import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.exception.SongNotFoundException;
import com.akerke.music.model.Song;
import com.akerke.music.repository.ArtistRepository;
import com.akerke.music.repository.SongRepository;
import com.akerke.music.service.SongService;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Map;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Song getById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new SongNotFoundException(id));
    }

    @Override
    public Song save(SongDTO songDTO) {
        Song song = new Song(songDTO.title(), songDTO.duration(), songDTO.releaseYear(), songDTO.genre(), artistRepository.findById(songDTO.artistId()).orElse(null));
        return songRepository.save(song);
    }

    @Override
    public boolean delete(Long id) {
        songRepository.deleteById(id);
        return true;
    }

    @Override
    public Song update(Long id, SongDTO songDTO) {
        Song song = getById(id);
        song.setTitle(songDTO.title());
        song.setGenre(songDTO.genre());
        song.setDuration(songDTO.duration());
        song.setReleaseYear(songDTO.releaseYear());

        return songRepository.save(song);
    }

    @Override
    public Song updatePartially(Long id, Map<String, Object> updatedFields) {
        Song song = getById(id);
        for(Map.Entry<String, Object> entry : updatedFields.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {
                case "title" -> song.setTitle((String) value);
                case "genre" ->  song.setGenre(Genre.valueOf((String) value));
                case "duration" -> song.setDuration((Long) value);
                case "releaseYear" -> song.setReleaseYear((Year) value);
            }
        }

        return songRepository.save(song);
    }
}
