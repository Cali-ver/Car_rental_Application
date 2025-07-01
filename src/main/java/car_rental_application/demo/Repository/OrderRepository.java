package car_rental_application.demo.Repository;


import car_rental_application.demo.Entity.PlacedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {}
