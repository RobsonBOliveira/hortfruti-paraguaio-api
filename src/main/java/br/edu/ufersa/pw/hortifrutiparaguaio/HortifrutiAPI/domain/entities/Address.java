package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

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

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

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
