package pl.yellow.rentallo.domain;

import java.time.LocalDate;

public class CarBooking {
    Car bookedCar;
    Client client;
    LocalDate startDay;
    LocalDate endDay;
    int totalPricePerDayInPolishGrosz;
    Address startLocation;
    Address endLocation;
}
