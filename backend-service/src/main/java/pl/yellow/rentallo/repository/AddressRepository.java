package pl.yellow.rentallo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.yellow.rentallo.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
