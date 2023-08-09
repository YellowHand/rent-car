package pl.yellow.rentallo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.domain.Pictures;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;
import pl.yellow.rentallo.repository.CarRepository;

import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {
    private final CarRepository carRepository;

    public DataInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("let's create some cars");
        Car mazda = Car.builder()
                .model("VW")
                .brand("mazda")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.V8)
                .bodyType(BodyType.HATCHBACK)
                .numberOfSeats(4)
                .trunkCapacityInLitres(250)
                .combustionPer100Km("5.0/100")
                .bodySerialNumber("123456")
                .pricePerDayInPolishGrosz(28000)
                .available(true)
                .rangeInKm(800)
                .pictures(new Pictures("https://img.freepik.com/premium-zdjecie/mazda-rx7-na-drodze_917278-30.jpg?w=1060",
                        List.of()))
                .build();
        carRepository.save(mazda);
        Car mazda2 = Car.builder()
                .model("VW")
                .brand("mazda")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.V8)
                .bodyType(BodyType.VAN)
                .numberOfSeats(5)
                .trunkCapacityInLitres(250)
                .combustionPer100Km("5.0/100")
                .bodySerialNumber("1234456")
                .pricePerDayInPolishGrosz(28000)
                .available(true)
                .rangeInKm(800)
                .pictures(new Pictures("https://img.freepik.com/premium-zdjecie/mazda-rx7-na-drodze_917278-30.jpg?w=1060",
                        List.of()))
                .build();
        carRepository.save(mazda2);
    }
}
