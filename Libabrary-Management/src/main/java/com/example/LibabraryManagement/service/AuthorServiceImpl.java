package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Author;
import com.example.LibabraryManagement.Entity.Book;
import com.example.LibabraryManagement.repository.AuthorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    public static final Logger LOGGER = LogManager.getLogger(AuthorServiceImpl.class);
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        LOGGER.info("Inside Get All Authors Method :: AuthorServiceImpl");
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @Override
    public Author getAuthorById(long id) {
        LOGGER.info("Inside getAuthorById method :: AuthorServiceImpl");
        Author author;
        author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Author found with Id " + id));
        return author;
    }

    @Override
    public void createAuthor(Author author) {
        LOGGER.info("Inside Create Author method to create an Author in DB :: AuthorServiceImpl");
        authorRepository.save(author);
    }
    @Override
    public void updateAuthor(Author author)
    {
        LOGGER.info("Inside update Author method to Update an Author in DB :: AuthorServiceImpl");
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long id) {
        LOGGER.info("Inside DeleteBookById :: AuthorServiceImpl");
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Author found with Id " + id));
        authorRepository.deleteById(author.getId());
    }
}
