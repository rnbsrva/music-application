package com.akerke.music.controller;

import com.akerke.music.dto.request.SongDTO;
import com.akerke.music.service.SongService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.akerke.music.validate.Validator.validate;

@RestController
@RequestMapping("song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("all")
    ResponseEntity<?> getAll (){
        return ResponseEntity.ok(songService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(songService.getById(id));
    }

    @PostMapping("new")
    ResponseEntity<?> save (
            @Valid
            @RequestBody SongDTO songDTO,
            BindingResult bindingResult
            ){
        validate(bindingResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(songService.save(songDTO));
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete (
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(songService.delete(id));
    }

    @PatchMapping("{id}")
    ResponseEntity<?> updatePartially(
            @PathVariable Long id,
            @RequestBody SongDTO songDTO
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(songService.updatePartially(id, songDTO));
    }

    @PutMapping("{id}")
    ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid
            @RequestBody SongDTO songDTO,
            BindingResult bindingResult
    ) {
        validate(bindingResult);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(songService.update(id, songDTO));
    }


}
