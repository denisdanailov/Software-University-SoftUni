package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query(value = "FROM Offer AS o JOIN o.agent AS ag JOIN o.apartment As ap " +
            "WHERE ap.apartmentType = 'three_rooms' " +
            "ORDER BY ap.area DESC, o.price ASC")
    List<Offer> findBestOffers();
}
