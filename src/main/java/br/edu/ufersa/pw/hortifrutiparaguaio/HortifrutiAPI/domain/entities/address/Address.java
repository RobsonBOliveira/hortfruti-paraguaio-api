package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_address")
@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;

    @Column(name = "id_client", nullable = false)
    private Long idClient;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "num")
    private long number;

    @Column(name = "zip_code")
    private String zipcode;
}
