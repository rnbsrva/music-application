package com.akerke.music.service.impl;

import com.akerke.music.dto.request.ConcertDTO;
import com.akerke.music.exception.ArtistNotFoundException;
import com.akerke.music.exception.ConcertNotFoundException;
import com.akerke.music.mapper.ConcertMapper;
import com.akerke.music.model.Artist;
import com.akerke.music.model.Concert;
import com.akerke.music.repository.ArtistRepository;
import com.akerke.music.repository.ConcertRepository;
import com.akerke.music.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;
    private final ConcertMapper concertMapper;
    private final ArtistRepository artistRepository;

    @Override
    public List<Concert> getAll() {
        return concertRepository.findAll();
    }

    @Override
    public Concert getById(Long id) {
        return concertRepository.findById(id).orElseThrow(()->new ConcertNotFoundException(id));
    }

    @Override
    public Concert save(ConcertDTO concertDTO) {
        return concertRepository.save(concertMapper.toModel(concertDTO, artistRepository.findAllById(concertDTO.artists())));
    }

    @Override
    public boolean delete(Long id) {
        concertRepository.deleteById(id);
        return true;
    }

    @Override
    public Concert update(Long id, ConcertDTO concertDTO) {
        Concert concert = getById(id);
        concertMapper.update(concert, concertDTO);
        return concertRepository.save(concert);
    }

    @Override
    public Concert deleteArtist(Long id, Long artistId) {
        Concert concert = getById(id);
        concert.getArtists().remove(artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(id)));
        return concertRepository.save(concert);
    }

    @Override
    public Concert addArtist(Long id, Long artistId) {
        Concert concert = getById(id);
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(id));
        if (!concert.getArtists().contains(artist))
            concert.getArtists().add(artist);
        return concertRepository.save(concert);
    }

}
