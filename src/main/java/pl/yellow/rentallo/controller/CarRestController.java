package pl.yellow.rentallo.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.yellow.rentallo.dto.CarDto;
import pl.yellow.rentallo.mapper.CarMapper;
import pl.yellow.rentallo.service.CarService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CarRestController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarRestController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("/cars")
    public List<CarDto> allCars() {
        log.info("all cars request");
        return carService.getAllCars()
                .stream()
                .map(car -> carMapper.fromEntityToDto(car))
                .toList();
    }

@GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable("id") Long carId) {
        log.info("trying to find car with id: [{}]", carId);
        return carMapper.fromEntityToDto(carService.findCarById(carId));
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody @Valid CarDto toSave) {
        log.info("Adding new car: [{}]", toSave);

        var result = carService.addCar(carMapper.fromDtoToEntity(toSave));
    }
}
