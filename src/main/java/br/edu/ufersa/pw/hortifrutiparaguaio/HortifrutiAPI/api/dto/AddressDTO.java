package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import jakarta.persistence.*;
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

}
