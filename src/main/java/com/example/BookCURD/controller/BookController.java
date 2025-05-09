package com.example.BookCURD.controller;

import com.example.BookCURD.entity.Books;
import com.example.BookCURD.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.BookCURD.dto.BooksDTO;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BooksService booksService;

@RequestMapping("/all")
private ResponseEntity<List<BooksDTO>> getAllBooks() {
    try {
        return ResponseEntity.ok(booksService.getAllBooks());
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    @PostMapping("/add")
    private ResponseEntity<BooksDTO> saveBooks(@RequestBody Books Books){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(booksService.saveBooks(Books));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<BooksDTO> getBooksById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(booksService.getBooksById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    private ResponseEntity<BooksDTO> updateBooks(@RequestBody Books books){
        try {
            return ResponseEntity.ok(booksService.updateBooks(books));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/del")
    private ResponseEntity<Void> deleteBooks(@RequestBody Books books){
        try {
            booksService.deleteBooks(books);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/byName")
    private ResponseEntity<List<BooksDTO>> getAllEmployeesByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(booksService.getAllByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
