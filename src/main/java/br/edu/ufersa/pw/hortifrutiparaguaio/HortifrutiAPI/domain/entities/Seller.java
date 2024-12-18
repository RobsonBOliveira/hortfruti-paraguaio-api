package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_seller")
@Getter
@Setter
@Entity
public class Seller{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column (name ="email", unique = true)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;
}
