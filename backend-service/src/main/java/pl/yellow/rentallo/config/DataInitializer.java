package pl.yellow.rentallo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Address;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.domain.Pictures;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;
import pl.yellow.rentallo.repository.AddressRepository;
import pl.yellow.rentallo.repository.CarRepository;
import pl.yellow.rentallo.repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public DataInitializer(CarRepository carRepository, ClientRepository clientRepository, AddressRepository addressRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createCars();
        createClients();
    }

    private void createCars() {
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

    private void createClients() {
        log.info("let's create some addresses");

        Address address1 = Address.builder()
                .street("Hobbiton")
                .zipCode("19-300")
                .city("Ełk")
                .houseNumber("5")
                .voivodeship("podkarpackie")
                .country("Poland")
                .build();

        addressRepository.save(address1);

        log.info("let's create some clients");
        Client client1 = Client.builder()
                .name("Adam")
                .surname("Kowalski")
                .pesel("12345567894")
                .email("email@gmail.com")
                .dateOfBirth(LocalDate.of(1997,05,12))
                .phone("57847834")
                .address(address1)
                .build();

        clientRepository.save(client1);
    }
}
