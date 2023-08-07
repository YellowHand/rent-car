package pl.yellow.rentallo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record CarBookingRequestDto(
        Long bookedCarId,
        Long clientId,
        LocalDate startDate,
        LocalDate endDate,
        Long startLocationId,
        Long endLocationId
) {
}
