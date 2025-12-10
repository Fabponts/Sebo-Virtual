package com.fabpont.dev.sebo_virtual.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDTO {
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String genre;
}
