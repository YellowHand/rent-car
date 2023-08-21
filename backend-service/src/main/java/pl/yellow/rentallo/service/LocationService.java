package pl.yellow.rentallo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.yellow.rentallo.domain.Address;
import pl.yellow.rentallo.exception.WrongAddressIdException;
import pl.yellow.rentallo.repository.AddressRepository;

@Service
@Slf4j
public class LocationService {

    private final AddressRepository addressRepository;

    public LocationService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .map(address -> {
                    log.info("Found address [{}]", address);
                    return address;
                })
                .orElseThrow(() -> new WrongAddressIdException("No address with given id [%d]".formatted(addressId)));
    }
}
