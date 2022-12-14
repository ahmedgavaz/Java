package com.example.json_processing_exercise.repositories;

import com.example.json_processing_exercise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from User order by RAND() limit 1",nativeQuery = true)
    Optional<User> findRandomUser();

    Optional<List<User>> findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc();
}
