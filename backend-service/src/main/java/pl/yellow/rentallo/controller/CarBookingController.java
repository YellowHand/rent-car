package pl.yellow.rentallo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yellow.rentallo.dto.CarBookingDto;
import pl.yellow.rentallo.dto.CarBookingRequestDto;
import pl.yellow.rentallo.service.CarBookingService;

@RestController
@RequestMapping("/api")
@Slf4j
public class CarBookingController {

    private final CarBookingService carBookingService;

    public CarBookingController(CarBookingService carBookingService) {
        this.carBookingService = carBookingService;
    }

    @PostMapping("/car-bookings")
    public CarBookingDto bookCar(@RequestBody CarBookingRequestDto bookingDto) {
        log.info("Car booking request: [{}]", bookingDto);
        carBookingService.bookCar(bookingDto);
        throw new RuntimeException("Not finished");
    }
}
