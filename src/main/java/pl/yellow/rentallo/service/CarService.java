package pl.yellow.rentallo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.exception.WrongCarIdException;
import pl.yellow.rentallo.repository.CarRepository;

import java.util.List;

@Service
@Slf4j
public class CarService {
    private  final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        log.info("getting all cars");
        var cars = carRepository.findAll();
        log.info("number of cars: [{}]", cars.size());
        log.debug("all cars {}", cars);
        return cars;
    }

    public Car findCarById(Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    log.info("found car: [{}]", car);
                    return car;
                })
                .orElseThrow(() -> new WrongCarIdException("No car with id: " + carId));
    }
}
