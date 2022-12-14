package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dto.DataExport;
import softuni.exam.models.entity.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("select new softuni.exam.models.dto.DataExport(c.carMake,c.carModel,c.kilometers,m.firstName,m.lastName,t.id,c.engine,t.price) from Task t " +
            "join t.car c " +
            "join t.mechanic m " +
            "join t.part p " +
            " where c.carType='coupe' " +
            "order by t.price desc ")
    Optional<List<DataExport>> findTheHighestPricedTasks();
}
