package com.fabpont.dev.sebo_virtual.repositories;

import com.fabpont.dev.sebo_virtual.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
