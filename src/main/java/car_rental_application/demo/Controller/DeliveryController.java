package car_rental_application.demo.Controller;



import car_rental_application.demo.Entity.Car;
import car_rental_application.demo.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery")
    public Car pickUpTheCar(@RequestParam Long carId) {
        return deliveryService.pickUpTheCar(carId);
    }
}
