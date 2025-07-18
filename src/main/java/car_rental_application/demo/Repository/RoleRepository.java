package car_rental_application.demo.Repository;

import car_rental_application.demo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
