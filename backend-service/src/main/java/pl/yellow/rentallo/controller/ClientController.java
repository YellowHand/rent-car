package pl.yellow.rentallo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yellow.rentallo.dto.ClientDto;
import pl.yellow.rentallo.mapper.ClientMapper;
import pl.yellow.rentallo.service.ClientService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping
    public List<ClientDto> allClients() {
        log.info("all clients request");
        return clientService.findAllClients()
                .stream()
                .map(clientMapper::fromEntityToDto)
                .toList();
    }

}
