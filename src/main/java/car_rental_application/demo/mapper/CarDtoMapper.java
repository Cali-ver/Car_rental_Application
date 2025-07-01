package car_rental_application.demo.mapper;



import car_rental_application.demo.Entity.Car;
import car_rental_application.demo.dto.CarDto;
import org.springframework.stereotype.Service;

@Service
public class CarDtoMapper {

    public static Car mapToCar(CarDto carDto) {

        return Car.builder()
                .registrationNr(carDto.getRegistrationNr())
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .isAvailable(carDto.getIsAvailable())
                .build();

    }

}
