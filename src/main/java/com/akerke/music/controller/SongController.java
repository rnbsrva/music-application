package com.akerke.music.controller;

import com.akerke.music.dto.SongDTO;
import com.akerke.music.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
            @RequestBody SongDTO songDTO
            ){
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
            @RequestBody Map<String, Object> updatedFields
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(songService.updatePartially(id, updatedFields));
    }

    @PutMapping("{id}")
    ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody SongDTO songDTO
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(songService.update(id, songDTO));
    }


}
