package car_rental_application.demo.repository;

import car_rental_application.demo.entity.CarPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarPackageRepository extends JpaRepository<CarPackage, Long> {

    Optional<CarPackage> findByPackageName(String name);

}
