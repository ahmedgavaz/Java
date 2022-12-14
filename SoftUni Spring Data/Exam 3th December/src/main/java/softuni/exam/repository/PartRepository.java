package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Part;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    Optional<Part> findFirstByPartName(String name);

    Optional<Part> findFirstById(Integer id);

}
