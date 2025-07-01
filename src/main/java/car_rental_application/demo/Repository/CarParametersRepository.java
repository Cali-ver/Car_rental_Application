package car_rental_application.demo.Repository;


import car_rental_application.demo.Entity.CarParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarParametersRepository extends JpaRepository<CarParameter, Long> {
}
