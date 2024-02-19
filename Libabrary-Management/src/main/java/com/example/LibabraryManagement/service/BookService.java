package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookById(long id);
    public void saveBooks(Book book);
    public void updateBookById(Book book);
    public void deleteBookById(long id);
}
