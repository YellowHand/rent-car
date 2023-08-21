package pl.yellow.rentallo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.yellow.rentallo.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
