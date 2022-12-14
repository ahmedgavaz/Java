package com.example.json_processing_exercise.services;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedProduct() throws IOException, JAXBException;
    void seedUser() throws IOException, JAXBException;
    void seedCategory() throws IOException, JAXBException;
    default void seedAll() throws IOException, JAXBException {
        seedUser();
        seedCategory();
        seedProduct();
    }
}
