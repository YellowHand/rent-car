package pl.yellow.rentallo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.service.CarService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> allCars() {
        log.info("all cars request");
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
}
