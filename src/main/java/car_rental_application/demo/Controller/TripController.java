package car_rental_application.demo.controller;

import car_rental_application.demo.entity.Trip;
import car_rental_application.demo.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip, Authentication authentication) {
        return ResponseEntity.ok(tripService.createTrip(trip, authentication.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllOpenTrips() {
        return ResponseEntity.ok(tripService.getAllOpenTrips());
    }

    @PostMapping("/{id}/join")
    public ResponseEntity<Trip> joinTrip(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(tripService.joinTrip(id, authentication.getName()));
    }

    @GetMapping("/{id}/cost")
    public ResponseEntity<Double> getCostPerPerson(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getCostPerPerson(id));
    }
}
