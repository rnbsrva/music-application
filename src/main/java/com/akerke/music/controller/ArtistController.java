package com.akerke.music.controller;

import com.akerke.music.dto.request.ArtistDTO;
import com.akerke.music.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.akerke.music.validate.Validator.validate;

@RestController
@RequestMapping("artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("all")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(artistService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getAll(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(artistService.getById(id));
    }

    @PostMapping("new")
    ResponseEntity<?> save(
            @Valid
            @RequestBody ArtistDTO artistDTO,
            BindingResult bindingResult
    ) {
        validate(bindingResult);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(artistService.save(artistDTO));
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(artistService.delete(id));
    }

    @PatchMapping("{id}")
    ResponseEntity<?> updatePartially(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updatedFields
    ) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(artistService.updatePartially(id, updatedFields));
    }

    @PutMapping("{id}")
    ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody ArtistDTO artistDTO
    ) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(artistService.update(id, artistDTO));
    }

}
