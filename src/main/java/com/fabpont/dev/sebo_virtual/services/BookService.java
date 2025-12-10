package com.fabpont.dev.sebo_virtual.services;

import com.fabpont.dev.sebo_virtual.DTO.request.BookRequestDTO;
import com.fabpont.dev.sebo_virtual.DTO.response.BookResponseDTO;
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

    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPublisher(bookRequestDTO.getPublisher());
        book.setSinopse(bookRequestDTO.getDescription());
        book.setGenre(bookRequestDTO.getGenre());

        Book saved = bookRepository.save(book);
        return BookResponseDTO.from(saved);
    }

    @Transactional
    public BookResponseDTO updateBook(Long bookId, BookRequestDTO bookRequestDTO) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book id not found: " + bookId));
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPublisher(bookRequestDTO.getPublisher());
        book.setSinopse(bookRequestDTO.getDescription());
        book.setGenre(bookRequestDTO.getGenre());

        Book updatedBook = bookRepository.save(book);
        return BookResponseDTO.from(updatedBook);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }

    public void deleteBook(Long bookId) throws ResourceNotFoundException {
       Book book = bookRepository.findById(bookId)
               .orElseThrow(() -> new ResourceNotFoundException("Book id not found: " + bookId));
       bookRepository.delete(book);
    }
}
