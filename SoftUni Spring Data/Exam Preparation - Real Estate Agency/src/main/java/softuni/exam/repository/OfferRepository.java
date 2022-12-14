package softuni.exam.repository;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dto.ExtractingElement;
import softuni.exam.models.entity.Offer;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {

    @Query("select new softuni.exam.models.dto.ExtractingElement(ag.firstName,ag.lastName,o.id,ap.area,t.townName,o.price) from Offer o join o.agent ag " +
            "join o.apartment ap " +
            "join ap.town t " +
            "where ap.apartmentType = 'three_rooms' " +
            "order by ap.area desc, o.price asc")
    Optional<List<ExtractingElement>> findTheBestOffers();
}
