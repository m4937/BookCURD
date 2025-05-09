package com.example.BookCURD.service;

import com.example.BookCURD.dto.BooksDTO;
import com.example.BookCURD.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BooksService {

    List<BooksDTO> getAllBooks();

    BooksDTO saveBooks(Books books);

    BooksDTO getBooksById(Long id);

    BooksDTO updateBooks(Books books);

    void deleteBooks(Books books);

    List<BooksDTO> getAllByName(String name);
}
