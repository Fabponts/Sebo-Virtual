package com.fabpont.dev.sebo_virtual.DTO.response;

import com.fabpont.dev.sebo_virtual.entities.Book;
// Opção 1: Record (melhor hoje em dia)
public record BookResponseDTO(
        Long id,
        String title,
        String author,
        String publisher,
        String sinopse,
        String genre
) {
    public static BookResponseDTO from(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getSinopse(),
                book.getGenre()
        );
    }
}