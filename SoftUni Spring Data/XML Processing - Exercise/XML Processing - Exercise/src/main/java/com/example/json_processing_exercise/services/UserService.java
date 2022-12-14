package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.entities.User;
import com.example.json_processing_exercise.entities.dto.UserWithSoldProductDTO;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserWithSoldProductDTO> findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc() throws IOException, JAXBException;
}

