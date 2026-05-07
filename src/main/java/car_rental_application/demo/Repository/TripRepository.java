package car_rental_application.demo.repository;

import car_rental_application.demo.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStatus(String status);
    List<Trip> findByDestinationContainingIgnoreCase(String destination);
}
