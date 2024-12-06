package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.stock;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "stock")
@Getter
@Setter
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproductstock ")
    private long idProductStock;
    @Column(name = "quantity")
    private int quantity;

}
