package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "product")
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Long idProduct;
    @Column(name = "idsalesman")
    private int idSalesMan;
    @Column(name = "name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name = "price")
    private double price;

}
