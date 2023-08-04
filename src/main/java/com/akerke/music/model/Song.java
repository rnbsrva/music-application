package com.akerke.music.model;

import com.akerke.music.constants.Genre;
import jakarta.persistence.*;

import java.time.Year;

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
    private Artist artist;

    public Song(String title, Long duration, Year releaseYear, Genre genre, Artist artist) {
        this.title = title;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
    }

    public Song() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
