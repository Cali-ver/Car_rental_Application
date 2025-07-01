package car_rental_application.demo.mapper;

import car_rental_application.demo.Entity.Role;
import car_rental_application.demo.Entity.User;
import car_rental_application.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoMapper {

    public static UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toList())
        );
    }

    public static List<UserDto> mapUserToUserDto(List<User> users) {
        return users.stream()
                .map(UserDtoMapper::mapUserToUserDto)
                .collect(Collectors.toList());
    }
}
