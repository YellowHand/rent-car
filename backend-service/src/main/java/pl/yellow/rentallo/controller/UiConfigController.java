package pl.yellow.rentallo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yellow.rentallo.domain.enumeration.BodyType;
import pl.yellow.rentallo.domain.enumeration.EngineType;
import pl.yellow.rentallo.domain.enumeration.FuelType;
import pl.yellow.rentallo.dto.ConfigItem;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/config")
public class UiConfigController {


    @GetMapping("/fuel-types")
    public List<ConfigItem<String, String>> getFuelTypes() {
// call values on enum
        return Arrays.stream(FuelType.values())
                .map(fuelType ->
                        new ConfigItem<>(fuelType.name(), fuelType.fuelDescription()))
                .toList();
    }

    @GetMapping("/body-types")
    public List<ConfigItem<String, String>> getCarBodyTypes() {
        return Arrays.stream(BodyType.values())
                .map(bodyTypes ->
                        new ConfigItem<>(bodyTypes.name(), bodyTypes.description()))
                .toList();
    }

    @GetMapping("/engine-types")
    public List<ConfigItem<String, String>> getCarEngineTypes() {
        return Arrays.stream(EngineType.values())
                .map(engineType ->
                        new ConfigItem<>(engineType.name(), engineType.description()))
                .toList();
    }
}
