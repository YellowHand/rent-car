package pl.yellow.rentallo.dto;

import java.time.LocalDate;


public record CarBookingRequestDto(
        Long bookedCarId,
        Long clientId,
        LocalDate startDate,
        LocalDate endDate,
        Long startLocationId,
        Long endLocationId
) {
}
