package pl.yellow.rentallo.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;
    String brand;
    @Enumerated(EnumType.STRING)
    FuelType fuelType;
    @Enumerated(EnumType.STRING)
    EngineType engineType;
    @Enumerated(EnumType.STRING)
    BodyType bodyType;
    int numberOfSeats;
    int trunkCapacityInLitres;
    String  combustionPer100Km;
    String bodySerialNumber;
    int pricePerDayInPolishGrosz;
    boolean available;
    int rangeInKm;
    Pictures pictures;
}
