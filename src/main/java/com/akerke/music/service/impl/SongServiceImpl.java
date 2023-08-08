package com.akerke.music.service.impl;

import com.akerke.music.constants.Genre;
import com.akerke.music.dto.SongResponseDTO;
import com.akerke.music.dto.request.SongDTO;
import com.akerke.music.exception.SongNotFoundException;
import com.akerke.music.mapper.SongMapper;
import com.akerke.music.model.Song;
import com.akerke.music.repository.ArtistRepository;
import com.akerke.music.repository.SongRepository;
import com.akerke.music.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final SongMapper songMapper;

    @Override
    public List<SongResponseDTO> getAll() {
        return songRepository.findAll().stream().map(songMapper::toSongResponseDTO).toList();
    }

    @Override
    public SongResponseDTO getById(Long id) {
        return songRepository.findById(id).map(songMapper::toSongResponseDTO).orElseThrow(() -> new SongNotFoundException(id));
    }

    @Override
    public SongResponseDTO save(SongDTO songDTO) {
        Song song = songMapper.toModel(songDTO, artistRepository.findById(songDTO.artistId()).orElse(null));
        songRepository.save(song);
        return songMapper.toSongResponseDTO(song);
    }

    @Override
    public boolean delete(Long id) {
        songRepository.deleteById(id);
        return true;
    }

    @Override
    public SongResponseDTO update(Long id, SongDTO songDTO) {
        Song song = songMapper.toModel(songDTO, artistRepository.findById(songDTO.artistId()).orElse(null));
        songRepository.save(song);
        return songMapper.toSongResponseDTO(song);
    }

    @Override
    public SongResponseDTO updatePartially(Long id, SongDTO songDTO) {
        SongResponseDTO songResponseDTO = getById(id);
        Song song = songMapper.toModelFromResponseDTO(songResponseDTO, artistRepository.findById(songResponseDTO.artistId()).orElse(null));
        songMapper.update(songDTO, song);
        songRepository.save(song);
        return this.getById(id);
    }
}
