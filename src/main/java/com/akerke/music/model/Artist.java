package com.akerke.music.model;

import com.akerke.music.constants.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String country;
    private Integer yearsActive;
    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL
    )
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

}
