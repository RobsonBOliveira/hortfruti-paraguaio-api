package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "seller")
@Getter
@Setter
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseller")
    private long id;
    @Column(name = "CNPJ")
    private String cnpj;
}
