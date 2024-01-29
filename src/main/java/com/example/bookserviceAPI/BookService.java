package com.example.bookserviceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final NotificationService notificationService;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(NotificationService notificationService, BookRepository bookRepository) {
        this.notificationService = notificationService;
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author, int year) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);

        notificationService.notify(book);
        bookRepository.addBook(book);

        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

}
