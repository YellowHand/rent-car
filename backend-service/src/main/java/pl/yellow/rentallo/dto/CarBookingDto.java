package pl.yellow.rentallo.dto;

import pl.yellow.rentallo.domain.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CarBookingDto(
        Long id,
        CarDto bookerCar,
        ClientDto client,
        LocalDate startDate,
        LocalDate endDate,
        int totalPricePerDayInPolishGrosz,
        AddressDto startLocation,
        AddressDto endLocation,
        LocalDateTime creationTimestamp,
        LocalDateTime updateTimestamp) {

}
