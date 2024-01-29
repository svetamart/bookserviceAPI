package com.example.bookserviceAPI;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyBookRepository implements BookRepository{

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public void addBook(Book book) {
        book.setId(generateUniqueId());
        books.add(book);
    }

    private Long generateUniqueId() {
        return System.currentTimeMillis();
    }
}
