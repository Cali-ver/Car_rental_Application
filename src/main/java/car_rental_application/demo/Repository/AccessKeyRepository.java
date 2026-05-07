package car_rental_application.demo.repository;



import car_rental_application.demo.entity.AccessKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessKeyRepository extends JpaRepository<AccessKey, Long> {
}
