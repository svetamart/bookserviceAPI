package com.example.bookserviceAPI;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notify(Book book) {
        System.out.println("A new book has been created: " + book.getTitle());
    }
}
