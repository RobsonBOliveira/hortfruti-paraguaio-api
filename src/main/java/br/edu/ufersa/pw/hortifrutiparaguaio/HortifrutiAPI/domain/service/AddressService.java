package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.AddressDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(final AddressRepository repository) {this.repository = repository;}

    public List<AddressDTO> findAll() {
        List<AddressDTO> result = repository.findAll().stream().map(Address -> new AddressDTO(Address))
        .collect(Collectors.toList());
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<AddressDTO> findByClientId(Long clientId) {
        List<Address> result = repository.findAll();
        return result.stream()
                .filter(address -> address.getIdClient().equals(clientId))
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }


    public AddressDTO createAddress(final Address dto) {
        repository.save(dto);
        return new AddressDTO(dto);
    }

    public AddressDTO delete(final Long idAddress) {
        Optional<Address> address = repository.findById(idAddress);
        if (address.isPresent()) {
            repository.delete(address.get());
            return new AddressDTO(address.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public AddressDTO updateAddress(final Address dto) {
        Optional<Address> address = repository.findById(dto.getId());
        if (address.isPresent()) {
            repository.save(dto);
            return new AddressDTO(dto);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
