package pl.yellow.rentallo.service;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.domain.CarBooking;
import pl.yellow.rentallo.dto.CarBookingRequestDto;
import pl.yellow.rentallo.repository.CarBookingRepository;

@Service
@Slf4j
public class CarBookingService {
    private final CarBookingRepository carBookingRepository;
    private final CarService carService;

    public CarBookingService(CarBookingRepository carBookingRepository, CarService carService) {
        this.carBookingRepository = carBookingRepository;
        this.carService = carService;
    }


    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Booking car with request: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());

        return null;
    }
}