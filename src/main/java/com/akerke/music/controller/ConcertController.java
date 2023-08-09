package com.akerke.music.controller;

import com.akerke.music.dto.request.ConcertDTO;
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
            @Valid
            @RequestBody ConcertDTO concertDTO,
            BindingResult bindingResult
    ) {
        validate(bindingResult);
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
            @Valid
            @RequestBody ConcertDTO concertDTO,
            BindingResult bindingResult
    ) {
        validate(bindingResult);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(concertService.update(id, concertDTO));
    }


    @DeleteMapping("{id}/delete/{artist_id}")
    ResponseEntity<?> deleteArtist (
            @PathVariable Long id,
            @PathVariable Long artist_id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(concertService.deleteArtist(id, artist_id));

    }

    @PatchMapping("{id}/add/{artist_id}")
    ResponseEntity<?> addArtist (
            @PathVariable Long id,
            @PathVariable Long artist_id

    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(concertService.addArtist(id, artist_id));

    }

}
