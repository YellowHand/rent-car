package pl.yellow.rentallo.dto;

import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;

public record CarDto(
        Long id,
        String model,
        String brand,
        FuelType fuelType,
        EngineType engineType,
        BodyType bodyType,
        int numberOfSeats,
        int trunkCapacityInLitres,
        String combustionPer100Km,
        String bodySerialNumber,
        int pricePerDayInPolishGrosz,
        boolean available,
        int rangeInKm
) {
}
