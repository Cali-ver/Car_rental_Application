package car_rental_application.demo.Entity;

import car_rental_application.demo.constant.FuelType;
import car_rental_application.demo.constant.GearBoxType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
public class CarParameter {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_box_type", nullable = false)
    private GearBoxType gearBoxType;

    @Column(name = "number_of_doors", nullable = false)
    private Integer numberOfDoors;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @Column(name = "is_air_conditioning_available", nullable = false)
    private Boolean isAirConditioningAvailable;

    @JsonIgnore
    @OneToOne(mappedBy = "carParameters")
    private Car car;

}
