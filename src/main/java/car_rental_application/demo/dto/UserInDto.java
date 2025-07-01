package car_rental_application.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserInDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;

}
