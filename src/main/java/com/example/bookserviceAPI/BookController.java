package com.example.bookserviceAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestParam String title, @RequestParam String author, @RequestParam int year) {
        return new ResponseEntity<>(bookService.createBook(title, author, year), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getAll",
            method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

}
