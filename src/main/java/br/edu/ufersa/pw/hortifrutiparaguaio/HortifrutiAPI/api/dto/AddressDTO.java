package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private Long idClient;
    private String street;
    private String city;
    private String state;
    private long number;
    private String zipcode;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.idClient = address.getClient().getId();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
    }
}
