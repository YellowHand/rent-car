package pl.yellow.rentallo.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Car bookedCar;
    Client client;
    LocalDate startDay;
    LocalDate endDay;
    int totalPricePerDayInPolishGrosz;
    Address startLocation;
    Address endLocation;
}
