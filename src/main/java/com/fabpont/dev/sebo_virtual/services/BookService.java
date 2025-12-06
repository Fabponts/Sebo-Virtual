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

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setSinopse(bookDTO.getDescription());
        book.setGenre(bookDTO.getGenre());

        Book saved = bookRepository.save(book);

        BookDTO response = new BookDTO();
        response.setTitle(saved.getTitle());
        response.setAuthor(saved.getAuthor());
        response.setPublisher(saved.getPublisher());
        response.setDescription(saved.getSinopse());
        response.setGenre(saved.getGenre());

        return response;
    }

    public Book updateBook(Long book_id, BookDTO bookDTO){
        if(bookRepository.existsById(book_id)){
            Book book= bookRepository.findById(book_id).get();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setPublisher(bookDTO.getPublisher());
            book.setSinopse(bookDTO.getDescription());
            book.setGenre(bookDTO.getGenre());
            return bookRepository.save(book);
        }else {
            throw new RuntimeException("Book Id not found: " + book_id);
        }
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
