package car_rental_application.demo.Controller;


import car_rental_application.demo.Entity.Role;
import car_rental_application.demo.Entity.User;
import car_rental_application.demo.dto.CreditCardDto;
import car_rental_application.demo.dto.UserDto;
import car_rental_application.demo.dto.UserInDto;
import car_rental_application.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserInDto saveUser(@RequestBody UserInDto userInDto) {
        return userService.saveUser(userInDto);
    }

    @PostMapping("/api/auth/register")
    public UserInDto registerUser(@RequestBody UserInDto userInDto) {
        return userService.saveUser(userInDto);
    }
    @PutMapping("/users/{id}")
    public car_rental_application.demo.Entity.User editUser(@PathVariable Long id, @RequestBody UserInDto userInDto) {
        return userService.editUser(id, userInDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/roles")
    public Role saveRole(@RequestBody Role role) {
        return userService.saveRole(role);
    }

    @PutMapping("/users/{username}/roles")
    public car_rental_application.demo.Entity.User  addRoleToUser(@PathVariable String username, @RequestParam String roleName) {
        return userService.addRoleToUser(username, roleName);
    }

    @DeleteMapping("/users/{username}/roles/{roleName}")
    public void deleteUserRole(@PathVariable String username, @PathVariable String roleName) {
        userService.deleteUserRole(username, roleName);
    }

    @PutMapping("/users/{username}/creditCards")
    public User addCreditCardToUser(@PathVariable String username, @RequestBody CreditCardDto creditCardDto) {
        return userService.addCreditCardToUser(username, creditCardDto);
    }


    @DeleteMapping("/users/{username}/creditCards")
    public void deleteUserCreditCard(@PathVariable String username) {
        userService.deleteUserCreditCard(username);
    }

}
