package com.example.cardealer.repositories;

import com.example.cardealer.domain.dtos.SalesDiscountsDTO;
import com.example.cardealer.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    //ca(ca.make,ca.model,ca.travelledDistance)
    @Query("select new com.example.cardealer.domain.dtos.SalesDiscountsDTO" +
            "(ca.make,ca.model,ca.travelledDistance,c.name,s.discountPercentage/100,sum(p.price)) from Sale s " +
            "join s.car ca " +
            "join s.customer c " +
            "join ca.parts p " +
            "group by s.id")
    Optional<List<SalesDiscountsDTO>> findAllBy();
}
