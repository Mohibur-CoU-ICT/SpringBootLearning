package com.springboot.learning.service;

import com.springboot.learning.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {
    static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Java: The Complete Reference", "Herbert Schildt"));
        books.add(new Book(2, "Head First Java", "Kathy Sierra"));
        books.add(new Book(3, "Thinking in Java", "Bruce Eckel"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(int id) {
        Book book = null;
        Optional<Book> optionalBook = books.stream().filter(b -> b.getId() == id).findFirst();
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }
}
