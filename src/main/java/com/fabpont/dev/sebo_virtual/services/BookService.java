package com.fabpont.dev.sebo_virtual.services;

import com.fabpont.dev.sebo_virtual.DTO.BookCreateDTO;
import com.fabpont.dev.sebo_virtual.entities.Book;
import com.fabpont.dev.sebo_virtual.exceptions.ResourceNotFoundException;
import com.fabpont.dev.sebo_virtual.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookCreateDTO addBook(BookCreateDTO bookCreateDTO) {
        Book book = new Book();
        book.setTitle(bookCreateDTO.getTitle());
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setPublisher(bookCreateDTO.getPublisher());
        book.setSinopse(bookCreateDTO.getDescription());
        book.setGenre(bookCreateDTO.getGenre());

        Book saved = bookRepository.save(book);

        BookCreateDTO response = new BookCreateDTO();
        response.setTitle(saved.getTitle());
        response.setAuthor(saved.getAuthor());
        response.setPublisher(saved.getPublisher());
        response.setDescription(saved.getSinopse());
        response.setGenre(saved.getGenre());

        return response;
    }
    @Transactional
    public Book updateBook(Long bookId, BookCreateDTO bookCreateDTO) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book id not found: " + bookId));

        book.setTitle(bookCreateDTO.getTitle());
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setPublisher(bookCreateDTO.getPublisher());
        book.setSinopse(bookCreateDTO.getDescription());
        book.setGenre(bookCreateDTO.getGenre());

        return bookRepository.save(book);

    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }

    public void deleteBook(Long book_id) {
        if (bookRepository.existsById(book_id)) {
            bookRepository.deleteById(book_id);
        }
        else{
            throw new RuntimeException("Book Id not found: " + book_id);
        }
    }
}
