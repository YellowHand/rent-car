package pl.yellow.rentallo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String pesel;
    String email;
    LocalDate dateOfBirth;
    String phone;
    @ManyToOne
    Address address;
    LocalDateTime accountCreated;


    @PrePersist
    void setAccountCreated() {
        accountCreated = LocalDateTime.now();
    }
}
