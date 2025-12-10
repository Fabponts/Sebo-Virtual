package com.fabpont.dev.sebo_virtual.controllers;

import com.fabpont.dev.sebo_virtual.DTO.BookCreateDTO;
import com.fabpont.dev.sebo_virtual.entities.Book;
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
    public BookCreateDTO createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO){
        return bookService.addBook(bookCreateDTO);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@Valid @PathVariable Long id) {
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
