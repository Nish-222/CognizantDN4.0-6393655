package com.cogn.service;

import com.cogn.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void addBook(String name){
        System.out.println("Adding book: " + name);
        bookRepository.saveBook(name);
    }
}
