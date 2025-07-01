package car_rental_application.demo.mapper;



import car_rental_application.demo.Entity.CarPackage;
import car_rental_application.demo.dto.CarPackageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarPackageDtoMapper {

    public static CarPackage mapToCarPackage(CarPackageDto carPackageDto) {

        return CarPackage.builder()
                .packageName(carPackageDto.getPackageName())
                .pricePerHour(carPackageDto.getPricePerHour())
                .cars(new ArrayList<>())
                .build();

    }

}
