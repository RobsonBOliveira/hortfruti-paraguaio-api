package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "O cliente associado ao endereço não pode ser nulo!")
    private Client client;

    @Column(name = "street", nullable = false)
    @NotEmpty(message = "O campo rua não pode ser vazio!")
    private String street;

    @Column(name = "city", nullable = false)
    @NotEmpty(message = "O campo cidade não pode ser vazio!")
    private String city;

    @Column(name = "state", nullable = false)
    @NotEmpty(message = "O campo estado não pode ser vazio!")
    private String state;

    @Column(name = "num", nullable = false)
    @Min(value = 1, message = "O número deve ser maior ou igual a 1.")
    private long number;

    @Column(name = "zip_code", nullable = false)
    @NotEmpty(message = "O campo CEP não pode ser vazio!")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O formato do CEP deve ser 99999-999.")
    private String zipcode;
}
