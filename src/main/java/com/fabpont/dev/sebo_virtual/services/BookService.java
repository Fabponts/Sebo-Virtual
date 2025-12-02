package com.fabpont.dev.sebo_virtual.services;

import com.fabpont.dev.sebo_virtual.DTO.BookDTO;
import com.fabpont.dev.sebo_virtual.entities.Book;
import com.fabpont.dev.sebo_virtual.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public  BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setSinopse(bookDTO.getDescription());
        book.setGenre(bookDTO.getGenre());
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.deleteById(book.getId());
        }
        else{
            throw new RuntimeException("Book Id not found: " + book.getId());
        }
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }
}
