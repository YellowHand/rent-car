package pl.yellow.rentallo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.yellow.rentallo.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
