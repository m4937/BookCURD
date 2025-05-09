package com.example.BookCURD.repository;

import com.example.BookCURD.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    //Custom Finder Method
    List<Books> findByName(String name);
}
