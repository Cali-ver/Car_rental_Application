package car_rental_application.demo.Controller;



import car_rental_application.demo.dto.UserInDto;
import car_rental_application.demo.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public void registerUser(@RequestBody UserInDto userInDto) {
        registrationService.registerUser(userInDto);
    }

}
