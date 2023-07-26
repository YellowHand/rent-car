package pl.yellow.rentallo.mapper;

import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Car;
import pl.yellow.rentallo.dto.CarDto;

@Component
public class CarMapper implements Mapper<Car, CarDto>{
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return null;
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return null;
    }
}
