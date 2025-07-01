package car_rental_application.demo.service;



import car_rental_application.demo.Entity.User;
import car_rental_application.demo.JWT.PasswordValidator;
import car_rental_application.demo.Repository.UserRepository;
import car_rental_application.demo.dto.UserInDto;
import car_rental_application.demo.exception.ExistingEntityException;
import car_rental_application.demo.exception.WeakPasswordException;
import car_rental_application.demo.mapper.UserInDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public void registerUser(UserInDto userInDto) {

        if (userRepository.findByUsername(userInDto.getUsername()).isPresent()) {

            throw new ExistingEntityException("User With Given Username Already Exists!");

        } else if (!PasswordValidator.matcher(userInDto.getPassword()).matches()) {

            throw new WeakPasswordException("Password Must Contains Minimum Eight Characters," +
                    " At Least One Uppercase Letter, One Lowercase Letter And One Number!");

        } else {

            log.info("Registration of new user");
            User user = (User) UserInDtoMapper.mapToUser(userInDto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            userService.addRoleToUser(user.getUsername(), "ROLE_USER");

        }
    }

}