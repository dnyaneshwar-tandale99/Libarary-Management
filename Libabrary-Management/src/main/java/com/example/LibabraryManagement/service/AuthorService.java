package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> getAllAuthors();
    public Author getAuthorById(long id);
    public void createAuthor(Author author);
    public void updateAuthor(Author author);
    public void deleteAuthor(long id);
}
