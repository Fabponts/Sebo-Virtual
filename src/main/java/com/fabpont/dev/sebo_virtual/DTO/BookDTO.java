package com.fabpont.dev.sebo_virtual.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String genre;
}
