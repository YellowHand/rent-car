package pl.yellow.rentallo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.exception.WrongClientIdException;
import pl.yellow.rentallo.repository.ClientRepository;

import java.util.List;

@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .map(client -> {
                    log.info("found client: [{}]", client);
                    return client;
                })
                .orElseThrow(() -> new WrongClientIdException("No client with id [%d] found".formatted(clientId)));
    }

    public List<Client> findAllClients() {
        log.info("getting all cars");

        var clients = clientRepository.findAll();

        log.info("number of found clients: [{}]", clients.size());
        log.debug("found clients: {}", clients);
        return clients;
    }
}
