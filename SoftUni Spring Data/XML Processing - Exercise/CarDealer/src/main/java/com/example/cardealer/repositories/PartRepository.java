package com.example.cardealer.repositories;

import com.example.cardealer.domain.entities.Part;
import com.example.cardealer.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
    @Query(value = "select * from Part p order by rand() limit 1;",nativeQuery = true)
    Optional<Part> findRandomPart();
}
