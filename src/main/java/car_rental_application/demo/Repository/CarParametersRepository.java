package car_rental_application.demo.repository;


import car_rental_application.demo.entity.CarParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarParametersRepository extends JpaRepository<CarParameter, Long> {
}
