package com.example.LibabraryManagement.service;

import com.example.LibabraryManagement.Entity.Publisher;
import com.example.LibabraryManagement.repository.PublisherRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    public static final Logger LOGGER = LogManager.getLogger(PublisherServiceImpl.class);
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        LOGGER.info("Inside Get All Publisher Method :: PublisherServiceImpl");
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers;
    }

    @Override
    public Publisher getPublisherById(long id) {
        LOGGER.info("Inside getPublisherById method :: PublisherServiceImpl");
        Publisher publisher;
        publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Publisher found with Id " + id));
        return publisher;
    }

    @Override
    public void createPublisher(Publisher publisher) {
        LOGGER.info("Inside Create Publisher method to create an Publisher in DB :: PublisherServiceImpl");
        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        LOGGER.info("Inside update Publisher method to Update an Publisher in DB :: PublisherServiceImpl");
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(long id) {
        LOGGER.info("Inside DeletePublisherById :: PublisherServiceImpl");
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Publisher found with Id " + id));
        publisherRepository.deleteById(publisher.getId());
    }

}
