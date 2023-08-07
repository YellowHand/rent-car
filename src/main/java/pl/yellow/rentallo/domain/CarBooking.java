package pl.yellow.rentallo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RENTS")
public class CarBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Car bookedCar;
    @ManyToOne
    Client client;
    LocalDate startDay;
    LocalDate endDay;
    int totalPricePerDayInPolishGrosz;
    @ManyToOne
    Address startLocation;
    @ManyToOne
    Address endLocation;
    LocalDateTime creationTimestamp;
    LocalDateTime updateTimestamp;

    @PrePersist
    void writeCreationTimestamp() {
        creationTimestamp = LocalDateTime.now();
        updateTimestamp = creationTimestamp;
    }

    @PreUpdate
    void writeUpdateTimestamp() {
        updateTimestamp = LocalDateTime.now();
    }
}
