package pl.yellow.rentallo.controller;

import org.junit.jupiter.api.Test;
import pl.yellow.rentallo.domain.enumeration.EngineType;

import static org.junit.jupiter.api.Assertions.*;

class UiConfigControllerTest {

    @Test
    public void playWithEnums() {
        EngineType electric = EngineType.ELECTRIC_MOTOR;
        assertEquals("ELECTRIC_MOTOR", electric.name());
        String electricMotor = "ELECTRIC_MOTOR";
        EngineType enumAgain = Enum.valueOf(EngineType.class, electricMotor);
        assertEquals(enumAgain, EngineType.ELECTRIC_MOTOR);
        assertThrows(IllegalArgumentException.class,
                () -> Enum.valueOf(EngineType.class, "WRONG"));
    }

}