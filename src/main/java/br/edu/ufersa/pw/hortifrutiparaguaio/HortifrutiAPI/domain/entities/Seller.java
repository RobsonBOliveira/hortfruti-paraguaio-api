package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_seller")
@Getter
@Setter
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj", unique = true)
    @Size(min = 18, max = 18, message = "CNPJ deve ter exatamente 18 caracteres!")
    private String cnpj;

    @NotEmpty(message = "O campo email não pode ser vazio!")
    @Email(message = "O email não é válido!")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres!")
    private String password;

    @Column(name = "status")
    private boolean status;
}
