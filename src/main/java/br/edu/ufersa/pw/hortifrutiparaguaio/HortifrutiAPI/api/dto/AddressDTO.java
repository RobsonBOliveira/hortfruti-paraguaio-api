package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddressDTO {

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.idClient = address.getIdClient();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
    }

    private Long id;
    private Long idClient;
    private String street;
    private String city;
    private String state;
    private long number;
    private String zipcode;

}
