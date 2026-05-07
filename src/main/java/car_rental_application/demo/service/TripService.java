package car_rental_application.demo.service;

import car_rental_application.demo.entity.Trip;
import car_rental_application.demo.entity.User;
import car_rental_application.demo.repository.TripRepository;
import car_rental_application.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public Trip createTrip(Trip trip, String creatorUsername) {
        log.info("Creating new trip to {} by user {}", trip.getDestination(), creatorUsername);
        User creator = userRepository.findByUsername(creatorUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        trip.setCreator(creator);
        trip.setStatus("OPEN");
        if (trip.getPassengers() == null) {
            trip.setPassengers(new ArrayList<>());
        }
        trip.getPassengers().add(creator); // Creator is the first passenger
        
        return tripRepository.save(trip);
    }

    public List<Trip> getAllOpenTrips() {
        return tripRepository.findByStatus("OPEN");
    }

    public Trip joinTrip(Long tripId, String username) {
        log.info("User {} joining trip {}", username, tripId);
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        
        if (!trip.getStatus().equals("OPEN")) {
            throw new RuntimeException("Trip is no longer open for joining");
        }

        if (trip.getPassengers().size() >= trip.getMaxSeats()) {
            throw new RuntimeException("Trip is full");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (trip.getPassengers().contains(user)) {
            throw new RuntimeException("User already joined this trip");
        }

        trip.getPassengers().add(user);
        
        if (trip.getPassengers().size() == trip.getMaxSeats()) {
            trip.setStatus("CLOSED");
        }

        return tripRepository.save(trip);
    }

    public Double getCostPerPerson(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        
        int passengerCount = trip.getPassengers().size();
        if (passengerCount == 0) return trip.getTotalCost();
        
        return trip.getTotalCost() / passengerCount;
    }
}
