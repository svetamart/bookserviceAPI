package com.example.bookserviceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    private final BookRepository bookRepository;

    @Autowired
    public DataProcessingService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> sortBooksByName() {
        List<Book> allBooks = bookRepository.getAllBooks();
        return allBooks.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksByYear(int year) {
        List<Book> allBooks = bookRepository.getAllBooks();
        return allBooks.stream()
                .filter(book -> book.getYear() >= year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> allBooks = bookRepository.getAllBooks();
        return allBooks.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

}
