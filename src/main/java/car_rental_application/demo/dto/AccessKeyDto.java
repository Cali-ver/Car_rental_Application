package car_rental_application.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccessKeyDto {

    private Long id;
    private String carPackage;
    private Integer hours;

}
