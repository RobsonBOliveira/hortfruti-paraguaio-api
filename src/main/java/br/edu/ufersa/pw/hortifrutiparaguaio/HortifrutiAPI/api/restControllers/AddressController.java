package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Address> getAddressById(@PathVariable Long idClient) {
        return addressRepository.findAllById(Collections.singleton(idClient));
    }

    @PostMapping("/address/post")
    public Address createAddress(@RequestBody Address address) {addressRepository.save(address); return address;}


    @DeleteMapping("/address/delete/{idAddress}")
    public void deleteAddress(@PathVariable Long idAddress) {addressRepository.deleteById(idAddress);}
}
