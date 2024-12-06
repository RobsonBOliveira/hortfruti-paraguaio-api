package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.salesman;


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
    @Column(name = "idsalesman")
    private long id;

    @Column(name = "CNPJ")
    private String cnpj;
}
