package com.example.cardealer.repositories;

import com.example.cardealer.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    @Query(value = "select * from Supplier s order by rand() limit 1;",nativeQuery = true)
    Optional<Supplier> findRandomSupplier();

    Optional<List<Supplier>> findAllByIsImporterFalse();
}
