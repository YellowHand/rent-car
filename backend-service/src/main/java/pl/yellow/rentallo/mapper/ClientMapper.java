package pl.yellow.rentallo.mapper;

import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Client;
import pl.yellow.rentallo.dto.ClientDto;

@Component
public class ClientMapper implements Mapper<Client, ClientDto> {

    private final AddressMapper addressMapper;

    public ClientMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .pesel(entity.getPesel())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .phone(entity.getPhone())
                .addressDto(addressMapper.fromEntityToDto(entity.getAddress()))
                .accountCreated(entity.getAccountCreated())
                .build();
    }

    @Override
    public Client fromDtoToEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.id())
                .name(dto.name())
                .surname(dto.surname())
                .pesel(dto.pesel())
                .email(dto.email())
                .dateOfBirth(dto.dateOfBirth())
                .phone(dto.phone())
                .address(addressMapper.fromDtoToEntity(dto.addressDto()))
                .accountCreated(dto.accountCreated())
                .build();
    }
}
