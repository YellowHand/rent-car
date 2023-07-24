package pl.yellow.rentallo.domain;


import lombok.Data;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;

@Data
public class Car {
    String model;
    String brand;
    FuelType fuelType;
    EngineType engineType;
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
