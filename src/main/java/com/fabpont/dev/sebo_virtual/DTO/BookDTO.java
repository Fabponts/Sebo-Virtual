package com.fabpont.dev.sebo_virtual.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String genre;
    private String releaseDate;
}
