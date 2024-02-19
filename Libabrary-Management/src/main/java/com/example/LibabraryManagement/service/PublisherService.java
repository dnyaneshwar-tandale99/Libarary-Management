package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Author;
import com.example.LibabraryManagement.Entity.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> getAllPublishers();
    public Publisher getPublisherById(long id);
    public void createPublisher(Publisher publisher);
    public void updatePublisher(Publisher publisher);
    public void deletePublisher(long id);
}
