package pl.yellow.rentallo.dto;


public record AddressDto(
        Long id,
        String street,
        String zipCode,
        String city,
        String houseNumber,
        String voivodeship,
        String country
) {
}
