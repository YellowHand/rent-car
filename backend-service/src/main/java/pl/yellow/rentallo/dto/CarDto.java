package pl.yellow.rentallo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;

@Builder
public record CarDto(
        Long id,
        @NotNull
        @Size(min = 1)
        String model,
        @NotNull
        @Size(min = 2)
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
        int rangeInKm,
        @NotNull
        PicturesDto pictures
) {
}
