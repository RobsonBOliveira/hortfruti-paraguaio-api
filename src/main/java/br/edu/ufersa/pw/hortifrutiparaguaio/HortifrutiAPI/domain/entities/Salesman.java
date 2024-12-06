package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "salesman")
@Getter
@Setter
@Entity
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalesman")
    private long id;

    @Column(name = "CNPJ")
    private String cnpj;
}
