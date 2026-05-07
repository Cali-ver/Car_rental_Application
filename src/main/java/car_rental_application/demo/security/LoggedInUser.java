package car_rental_application.demo.security;


import car_rental_application.demo.entity.User;
import car_rental_application.demo.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUser {

    private final UserRepository userRepository;

    public LoggedInUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser() {

        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        String username = principal.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

    }

}
