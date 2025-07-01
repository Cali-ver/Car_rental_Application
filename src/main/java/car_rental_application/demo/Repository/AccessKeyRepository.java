package car_rental_application.demo.Repository;



import car_rental_application.demo.Entity.AccessKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessKeyRepository extends JpaRepository<AccessKey, Long> {
}
