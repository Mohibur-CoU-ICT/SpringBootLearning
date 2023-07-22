package com.springboot.learning.controller;

import com.springboot.learning.entity.Book;
import com.springboot.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }
}
