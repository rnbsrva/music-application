package com.akerke.music.controller;

import com.akerke.music.dto.ConcertDTO;
import com.akerke.music.dto.request.ArtistDTO;
import com.akerke.music.dto.request.SongDTO;
import com.akerke.music.service.ConcertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.akerke.music.validate.Validator.validate;

@RestController
@RequestMapping("concert")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    @GetMapping("all")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(concertService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getAll(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(concertService.getById(id));
    }

    @PostMapping("new")
    ResponseEntity<?> save(
            @RequestBody ConcertDTO concertDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(concertService.save(concertDTO));
    }


    @DeleteMapping("{id}")
    ResponseEntity<?> delete (
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(concertService.delete(id));
    }

    @RequestMapping(value={"{id}", "{id}"},
            method={RequestMethod.PATCH,RequestMethod.PUT})
    ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody ConcertDTO concertDTO
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(concertService.update(id, concertDTO));
    }



}
