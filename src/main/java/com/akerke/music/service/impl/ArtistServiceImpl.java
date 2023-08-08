package com.akerke.music.service.impl;

import com.akerke.music.dto.ArtistResponseDTO;
import com.akerke.music.dto.SongResponseDTO;
import com.akerke.music.dto.request.ArtistDTO;
import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.mapper.ArtistMapper;
import com.akerke.music.mapper.SongMapper;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Song;
import com.akerke.music.repository.ArtistRepository;
import com.akerke.music.repository.SongRepository;
import com.akerke.music.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;
    private final ArtistMapper artistMapper;
    private final SongMapper songMapper;

    @Override
    public List<ArtistResponseDTO> getAll() {
        List<Artist> artists = artistRepository.findAll();
        List<Song> songs = songRepository.findAll();
        List<ArtistResponseDTO> artistDTOS = new ArrayList<>();
        for (Artist artist : artists){
            songs = songs.stream()
                    .filter(song -> song.getArtist().getId().equals(artist.getId())).toList();
            List<SongResponseDTO> songDTOS = songs.stream().map(songMapper::toSongResponseDTO).toList();
            artistDTOS.add(artistMapper.toArtistResponseDTO(artist, songDTOS));
        }
        return artistDTOS;
    }

    @Override
    public ArtistResponseDTO getById(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));
        return artistMapper
                .toArtistResponseDTO(artist, artist.getSongs().stream().map(songMapper::toSongResponseDTO).toList());
    }

    @Override
    public ArtistResponseDTO save(ArtistDTO artistDTO) {
        Artist artist = artistMapper.toModel(artistDTO);
        artistRepository.save(artist);
        return artistMapper.toArtistResponseDTO(artist, new ArrayList<>());
    }

    @Override
    public boolean delete(Long id) {
        artistRepository.deleteById(id);
        return true;
    }

    @Override
    public ArtistResponseDTO update(Long id, ArtistDTO artistDTO) {
        artistRepository.save(artistMapper.toModel(artistDTO));
        return getById(id);
    }

    @Override
    public ArtistResponseDTO updatePartially(Long id, Map<String, Object> updatedFields) {
        ArtistResponseDTO artistResponseDTO = getById(id);
        Artist artist = artistMapper.toModelFromArtistResponseDTO(artistResponseDTO, new ArrayList<>());
        updatedFields.forEach((field, value)->{
            switch (field) {
                case "name" -> artist.setName((String) value);
                case "surname" ->  artist.setSurname((String) value);
                case "country" -> artist.setCountry((String) value);
                case "yearsActive" -> artist.setYearsActive((Integer) value);
            }
        });
        artistRepository.save(artist);
        return this.getById(id);
    }
}
