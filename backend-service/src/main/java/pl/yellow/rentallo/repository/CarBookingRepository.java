package pl.yellow.rentallo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.yellow.rentallo.domain.CarBooking;


public interface CarBookingRepository extends JpaRepository<CarBooking, Long> {
}
