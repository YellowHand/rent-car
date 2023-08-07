package pl.yellow.rentallo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TODO
public record ClientDto(
        Long id,
        String name,
        String surname,
        String pesel,
        String email,
        LocalDate dateOfBirth,
        String phone,
        AddressDto addressDto,
        LocalDateTime accountCreated
) {

}
