package car_rental_application.demo.Repository;

import car_rental_application.demo.Entity.CarPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarPackageRepository extends JpaRepository<CarPackage, Long> {

    Optional<CarPackage> findByPackageName(String name);

}
