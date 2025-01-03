package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.controllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/address")
    public ResponseEntity<?> getAddress() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/address/{idClient}")
    public ResponseEntity<?> getAddressById(@Valid @PathVariable Long idClient) {
        return new ResponseEntity<>(addressService.findByClientId(idClient), HttpStatus.OK);
    }

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity<?> deleteAddress(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(addressService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/address/post")
    public ResponseEntity<?> createAddress(@Valid @RequestBody Address address) {
        return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("/address/put")
    public ResponseEntity<?> updateAddress(@Valid @RequestBody Address updateAddress) {
        return new ResponseEntity<>(addressService.updateAddress(updateAddress), HttpStatus.OK);
    }
}
