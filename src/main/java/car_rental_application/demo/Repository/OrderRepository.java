package car_rental_application.demo.repository;


import car_rental_application.demo.entity.PlacedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {}
