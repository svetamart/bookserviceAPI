package com.example.bookserviceAPI;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
}
