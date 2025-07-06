package com.cogn.service;

import com.cogn.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for DI
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void addBook(String bookName){
        System.out.println("Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
