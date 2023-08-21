package pl.yellow.rentallo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.yellow.rentallo.exception.WrongDateInputException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarBookingServiceTest {

    @Autowired
    CarBookingService carBookingService;

    @Test
    void checkInjectedBean() {
        Assertions.assertNotNull(carBookingService, "Should not be null");
    }

    @Test
    void calculateFinalBookingPricePositiveCase() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        long pricePerDayInGrosz = 10_000;
        long calculatedPriceInPolishGrosz = carBookingService.calculateFinalBookingPrice(startDate,
                endDate, pricePerDayInGrosz);
        Assertions.assertEquals(30_000, calculatedPriceInPolishGrosz);
    }

    @Test
    void calculateFinalBookingPricWithWrongDatesRange_endDateInPast(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusDays(3);
        long pricePerDayInGrosz = 10_000;

        Assertions.assertThrows(WrongDateInputException.class,
                () -> carBookingService.calculateFinalBookingPrice(startDate, endDate, pricePerDayInGrosz));
    }

    @Test
    void calculateFinalBookingPricWithWrongDatesRange_endDateEqualsStartDate(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(0);
        long pricePerDayInGrosz = 10_000;

        Assertions.assertThrows(WrongDateInputException.class,
                () -> carBookingService.calculateFinalBookingPrice(startDate, endDate, pricePerDayInGrosz));
    }
}