package pl.yellow.rentallo.service;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Address;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.domain.CarBooking;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.dto.CarBookingRequestDto;
import pl.yellow.rentallo.exception.WrongDateInputException;
import pl.yellow.rentallo.repository.CarBookingRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class CarBookingService {
    private final CarBookingRepository carBookingRepository;
    private final CarService carService;
    private final ClientService clientService;
    private final LocationService locationService;

    public CarBookingService(CarBookingRepository carBookingRepository, CarService carService, ClientService clientService, LocationService locationService) {
        this.carBookingRepository = carBookingRepository;
        this.carService = carService;
        this.clientService = clientService;
        this.locationService = locationService;
    }


    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Booking car with request: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());
        Address startLocation = locationService.findAddressById(bookingDto.startLocationId());
        Address endLocation = locationService.findAddressById(bookingDto.endLocationId());
        long finalCarBookingPrice = calculateFinalBookingPrice(bookingDto.startDate(), bookingDto.endDate(), car.getPricePerDayInPolishGrosz());

        CarBooking bookingRecord = CarBooking.builder()
                .bookedCar(car)
                .client(client)
                .startDate(bookingDto.startDate())
                .endDate(bookingDto.endDate())
                .totalPricePerDayInPolishGrosz(finalCarBookingPrice)
                .startLocation(startLocation)
                .endLocation(endLocation)
                .build();
        CarBooking saved = carBookingRepository.save(bookingRecord);

        log.info("Created booking record: [{}]", saved);
        return saved;
    }

    public long calculateFinalBookingPrice(LocalDate startDate, LocalDate endDate, long pricePerDayInPolishGrosz) {
        if (startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
            throw new WrongDateInputException("Wrong dates provided, start date = [%s], end date = [%s]"
                    .formatted(startDate, endDate));
        }
        long numberOfDays = Period.between(startDate, endDate).getDays();
        long finalPriceInPolishGrosz = pricePerDayInPolishGrosz * numberOfDays;

        log.info("Final price for booking car starting on [{}] ending on [{}] is [{}]",
                startDate, endDate, finalPriceInPolishGrosz);
        return finalPriceInPolishGrosz;
    }
}
