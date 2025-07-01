package car_rental_application.demo.mapper;

import car_rental_application.demo.Entity.AccessKey;
import car_rental_application.demo.dto.AccessKeyDto;
import org.springframework.stereotype.Service;

@Service
public class AccessKeyDtoMapper {

    public static AccessKeyDto mapToAccessKeyDto(AccessKey accessKey) {
        return AccessKeyDto.builder()
                .id(accessKey.getId())
                .carPackage(accessKey.getCarPackage())
                .hours(accessKey.getHours())
                .build();
    }

}
