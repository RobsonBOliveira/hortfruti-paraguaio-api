package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping("/address")
    public List<Address> getAddress() {return addressRepository.findAll();}

    @RequestMapping("/address/{idClient}")
    public List<Address> getAddressById(@PathVariable Long idClient) {return addressRepository.findAllById(Collections.singleton(idClient));}

    @DeleteMapping("/address/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {addressRepository.deleteById(id);}

    @PostMapping("/address/post")
    public Address createAddress(@RequestBody Address address) {return addressRepository.save(address);}

    @PutMapping("/address/put/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address updateAddress) {
        updateAddress.setId(id);
        Address updatedAddress = addressRepository.save(updateAddress);
        return ResponseEntity.ok(updatedAddress);
    }
}
