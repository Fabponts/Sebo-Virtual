package com.fabpont.dev.sebo_virtual.controllers;

import com.fabpont.dev.sebo_virtual.DTO.request.BookRequestDTO;
import com.fabpont.dev.sebo_virtual.DTO.response.BookResponseDTO;
import com.fabpont.dev.sebo_virtual.entities.Book;
import com.fabpont.dev.sebo_virtual.exceptions.ResourceNotFoundException;
import com.fabpont.dev.sebo_virtual.services.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public BookResponseDTO createBook(@Valid @RequestBody BookRequestDTO bookRequestDTO){
        return bookService.addBook(bookRequestDTO);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@Valid @PathVariable Long id) throws ResourceNotFoundException {
         bookService.deleteBook(id);
    }

    @GetMapping("/books")
    public List<Book> getBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@Valid @PathVariable Long id) {
        return bookService.getBookById(id);
    }
}
