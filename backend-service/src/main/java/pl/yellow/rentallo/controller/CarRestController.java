package pl.yellow.rentallo.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.yellow.rentallo.dto.CarDto;
import pl.yellow.rentallo.mapper.CarMapper;
import pl.yellow.rentallo.service.CarService;

import java.net.URI;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Void> addCar(@RequestBody @Valid CarDto toSave, UriComponentsBuilder ucb) {
        log.info("Adding new car: [{}]", toSave);

        var result = carService.addCar(carMapper.fromDtoToEntity(toSave));
        URI path = ucb.path("/cars/{id}")
                .buildAndExpand(Map.of("id", result.getId())).toUri();
        return ResponseEntity.created(URI.create(path.getPath())).build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long carId) {
        log.info("trying to delete car with id: [{}]", carId);
        carService.deleteCarById(carId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cars/{id}")
    public CarDto replaceCar(@RequestBody @Valid CarDto toReplace,@PathVariable("id") Long carId) {
        log.info("trying to replace car by id: [{}] with content [{}]", carId, toReplace);
        var entityToReplace = carMapper.fromDtoToEntity(toReplace);
        return carMapper.fromEntityToDto(carService.replaceCar(carId, entityToReplace));
    }

    @PatchMapping("/cars/{id}")
    public CarDto updateCar(@RequestBody @Valid CarDto toReplace,@PathVariable("id") Long carId) {
        return null;
    }
}
