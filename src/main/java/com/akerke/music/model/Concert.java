package com.akerke.music.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;
    @ManyToMany
    @JoinTable(
            name = "concert_artists",
            joinColumns = @JoinColumn(name = "concert_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id")
    )
    private List<Artist> artists;

    public Concert() {

    }
}
