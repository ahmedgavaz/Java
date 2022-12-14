package com.example.cardealer.repositories;

import com.example.cardealer.domain.entities.Car;
import com.example.cardealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "select * from Car c order by rand() limit 1;",nativeQuery = true)
    Optional<Car> findRandomCar();

    Optional<List<Car>> findAllByMakeOrderByModelAscTravelledDistanceDesc(String moder);
    Optional<List<Car>> findAllBy();
}
