package com.fabpont.dev.sebo_virtual.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDTO {
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String genre;
}
