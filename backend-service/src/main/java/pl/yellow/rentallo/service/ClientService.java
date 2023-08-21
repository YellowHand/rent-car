package pl.yellow.rentallo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.exception.WrongClientIdException;
import pl.yellow.rentallo.repository.ClientRepository;

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
}
