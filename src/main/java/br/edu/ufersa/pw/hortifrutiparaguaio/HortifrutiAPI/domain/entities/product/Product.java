package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_product")
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "id_seller")
    private Long idSeller;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name="quantity")
    private int quantity;
}
