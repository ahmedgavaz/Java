package com.example.cardealer.repositories;

import com.example.cardealer.domain.dtos.CustomerTotalSalesDTO;
import com.example.cardealer.domain.entities.Customer;
import com.example.cardealer.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from Customer c order by rand() limit 1;",nativeQuery = true)
    Optional<Customer> findRandomCustomer();
    @Query(value = "select * from customer " +
            "order by birth_date asc,is_young_driver;",nativeQuery = true)
    Optional<List<Customer>> findAllOrderedByBirthDate();

    @Query("select new com.example.cardealer.domain.dtos.CustomerTotalSalesDTO(c.name,c.sales.size,sum(p.price)) from Customer c " +
            "join c.sales s " +
            "join s.car ca " +
            "join ca.parts p " +
            "group by c.id " +
            "order by sum(p.price) desc")
    Optional<List<CustomerTotalSalesDTO>> findAllBySalesIsNotNull();
}
