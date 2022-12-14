package com.example.json_processing_exercise.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedProduct() throws IOException;
    void seedUser() throws IOException;
    void seedCategory() throws IOException;
    default void seedAll() throws IOException {
        seedUser();
        seedCategory();
        seedProduct();
    }
}
