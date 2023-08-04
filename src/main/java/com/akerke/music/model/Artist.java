package com.akerke.music.model;

import com.akerke.music.constants.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String country;
    private Integer yearsActive;
    @OneToMany
    private List<Song> songs;

    public Artist(String name, String surname, String country, Integer yearsActive, List<Song> songs) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.yearsActive = yearsActive;
        this.songs = songs;
    }

    public Artist() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(Integer yearsActive) {
        this.yearsActive = yearsActive;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
