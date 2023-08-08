package com.akerke.music.model;

import com.akerke.music.constants.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long duration;
    private Year releaseYear;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
    @ManyToOne
    @JsonIgnore
    private Artist artist;

    public Song(String title, Long duration, Year releaseYear, Genre genre, Artist artist) {
        this.title = title;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
    }

    public Song(Long id, String title, Long duration, Year releaseYear, Genre genre, Artist artist) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
    }

    public Song() {

    }


}
