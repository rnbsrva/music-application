package com.akerke.music.service;

import com.akerke.music.dto.ConcertDTO;
import com.akerke.music.model.Concert;

import java.util.List;

public interface ConcertService {

    List<Concert> getAll();

    Concert getById(Long id);

    Concert save(ConcertDTO concertDTO);

    boolean delete(Long id);

    Concert update(Long id, ConcertDTO songDTO);

}
