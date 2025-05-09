package com.example.BookCURD.service.impl;

import com.example.BookCURD.dto.BooksDTO;
import com.example.BookCURD.entity.Books;
import com.example.BookCURD.repository.BooksRepository;
import com.example.BookCURD.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private  BooksRepository booksRepository;

    @Override
    public List<BooksDTO> getAllBooks() {
        List<Books> booksList = booksRepository.findAll();
        List<BooksDTO> Books =new ArrayList<>();
        for (Books book : booksList) {
            BooksDTO booksDTO =this.mapBookstoDTO(book);
            Books.add(booksDTO);
        }
        return Books;
    }

    private BooksDTO mapBookstoDTO(Books book) {
    BooksDTO booksDTO = new BooksDTO();
    booksDTO.setId(book.getId());
    booksDTO.setName(book.getName());
    return booksDTO;
    }

    @Override
    public BooksDTO saveBooks(Books books) {
     Books savebook= booksRepository.save(books);
return this.mapBookstoDTO(savebook);
    }

    @Override
    public BooksDTO getBooksById(Long id) {
        Optional<Books> book = booksRepository.findById(id);
    if(book.isPresent()){
        return this.mapBookstoDTO(book.get());
    }
        return null;
    }

    @Override
    public BooksDTO updateBooks(Books books) {
        Books updatebook= booksRepository.save(books);
    return this.mapBookstoDTO(updatebook);
    }

    @Override
    public void deleteBooks(Books books) {
        booksRepository.delete(books);
    }

    @Override
    public List<BooksDTO> getAllByName(String name) {
List<Books> booksList = booksRepository.findByName(name);
List<BooksDTO> Books =new ArrayList<>();
for (Books book : booksList) {
    BooksDTO booksDTO =this.mapBookstoDTO(book);
    Books.add(booksDTO);
}
return Books;
    }
}
