package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "O campo rua não pode ser vazio!")
    private String street;

    @Column(name = "city")
    @NotEmpty(message = "O campo cidade não pode ser vazio!")
    private String city;

    @Column(name = "state")
    @NotEmpty(message = "O campo estado não pode ser vazio!")
    private String state;

    @Column(name = "num")
    @NotEmpty(message = "O campo número não pode ser vazio!")
    private long number;

    @Column(name = "zip_code")
    @NotEmpty(message = "O campo CEP não pode ser vazio!")
    private String zipcode;
}
