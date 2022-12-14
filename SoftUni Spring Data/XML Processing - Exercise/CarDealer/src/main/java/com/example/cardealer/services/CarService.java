package com.example.cardealer.services;

import com.example.cardealer.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService{
    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String model);
    List<Car> findAllBy();
}
