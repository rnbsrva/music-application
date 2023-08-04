package com.akerke.music.service.impl;

import com.akerke.music.dto.ArtistDTO;
import com.akerke.music.dto.SongDTO;
import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Song;
import com.akerke.music.repository.ArtistRepository;
import com.akerke.music.repository.SongRepository;
import com.akerke.music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<ArtistDTO> getAll() {
        List<Artist> artists = artistRepository.findAll();
        List<Song> songs = songRepository.findAll();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist artist : artists){
            songs = songs.stream()
                    .filter(song -> song.getArtist().getId().equals(artist.getId())).toList();
            List<SongDTO> songDTOS = new ArrayList<>();
            for (Song song: songs){
                SongDTO songDTO = new SongDTO(song.getTitle(), song.getDuration(), song.getReleaseYear(), song.getGenre(), song.getArtist().getId());
                songDTOS.add(songDTO);
            }
            ArtistDTO artistDTO = new ArtistDTO(
                    artist.getName(),
                    artist.getSurname(),
                    artist.getCountry(),
                    artist.getYearsActive(),
                    songDTOS);
            artistDTOS.add(artistDTO);
        }
        return artistDTOS;
    }

    @Override
    public Artist getById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));
    }

    @Override
    public Artist save(ArtistDTO artistDTO) {
        Artist artist = new Artist(artistDTO.name(), artistDTO.surname(), artistDTO.country(), artistDTO.yearsActive(), new ArrayList<>());

        return artistRepository.save(artist);
    }

    @Override
    public boolean delete(Long id) {
        artistRepository.delete(this.getById(id));
        return true;
    }

    @Override
    public Artist update(Long id, ArtistDTO artistDTO) {
        Artist artist = getById(id);
        artist.setName(artistDTO.name());
        artist.setSurname(artistDTO.surname());
        artist.setCountry(artistDTO.country());
        artist.setYearsActive(artistDTO.yearsActive());

        artistRepository.save(artist);
        return artist;
    }

    @Override
    public Artist updatePartially(Long id, Map<String, Object> updatedFields) {
        Artist artist = getById(id);
        updatedFields.forEach((field, value)->{
            switch (field) {
                case "name" -> artist.setName((String) value);
                case "surname" ->  artist.setSurname((String) value);
                case "country" -> artist.setCountry((String) value);
                case "yearsActive" -> artist.setYearsActive((Integer) value);
            }
        });
        return artist;
    }
}
