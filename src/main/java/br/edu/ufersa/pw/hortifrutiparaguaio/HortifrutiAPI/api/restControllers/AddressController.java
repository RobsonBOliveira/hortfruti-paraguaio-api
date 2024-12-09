package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.AddressService;
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
        ResponseEntity<?> response = new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
        return response;
    }

    @RequestMapping("/address/{idClient}")
    public ResponseEntity<?> getAddressById(@PathVariable Long idClient) {
        ResponseEntity<?> response = new ResponseEntity<>(addressService.findByClientId(idClient), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<>(addressService.delete(id), HttpStatus.OK);
        return response;
    }

    @PostMapping("/address/post")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        ResponseEntity<?> response = new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/address/put")
    public ResponseEntity<?> updateAddress(@RequestBody Address updateAddress) {
        ResponseEntity<?> response = new ResponseEntity<>(addressService.updateAddress(updateAddress), HttpStatus.OK);
        return response;
    }
}
