package com.fabpont.dev.sebo_virtual.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(length = 20, nullable = false)
    private String genre;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(length = 30, nullable = false)
    private String publisher;

    @Column(length = 500, nullable = false)
    private String sinopse;

    public Book(){
    }

    public Book(String title, String author, String genre, LocalDate releaseDate, String publisher, String sinopse) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.sinopse = sinopse;
    }
}
