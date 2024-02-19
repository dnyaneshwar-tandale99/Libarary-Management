package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Book;
import com.example.LibabraryManagement.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LogManager.getLogger(BookServiceImpl.class);
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("Inside Get All Books Method :: BookServiceImpl");
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book getBookById(long id) {
        LOGGER.info("Inside getBookById method :: BookServiceImpl");
        Book book;
        book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Book found with Id " + id));
        return book;
    }

    @Override
    public void saveBooks(Book book) {
        LOGGER.info("Inside Save Books method to create an Book in DB :: BoookSerivceImpl");
        bookRepository.save(book);
    }

    @Override
    public void updateBookById(Book book) {
        LOGGER.info("Inside UpdateBookById :: BookServiceImpl");
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(long id) {
        LOGGER.info("Inside DeleteBookById :: BookServiceImpl");
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("no such id found in Database " + id));
        bookRepository.deleteById(book.getId());
    }
}
