package pl.yellow.rentallo.mapper;

import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.dto.ClientDto;

@Component
public class ClientMapper implements Mapper<Client, ClientDto> {

    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return null;
    }

    @Override
    public Client fromDtoToEntity(ClientDto dto) {
        return null;
    }
}
