package pl.yellow.rentallo.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Client {
    String name;
    String surname;
    String pesel;
    String email;
    LocalDate dateOfBirth;
    String phone;
    Address address;
    LocalDateTime accountCreated;
}
