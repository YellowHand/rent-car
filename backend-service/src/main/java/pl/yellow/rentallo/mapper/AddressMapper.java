package pl.yellow.rentallo.mapper;

import org.springframework.stereotype.Component;
import pl.yellow.rentallo.domain.Address;
import pl.yellow.rentallo.dto.AddressDto;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {
    @Override
    public AddressDto fromEntityToDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .houseNumber(entity.getHouseNumber())
                .voivodeship(entity.getVoivodeship())
                .country(entity.getCountry())
                .build();
    }

    @Override
    public Address fromDtoToEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.id())
                .street(dto.street())
                .zipCode(dto.zipCode())
                .city(dto.city())
                .houseNumber(dto.houseNumber())
                .voivodeship(dto.voivodeship())
                .country(dto.country())
                .build();
    }
}
