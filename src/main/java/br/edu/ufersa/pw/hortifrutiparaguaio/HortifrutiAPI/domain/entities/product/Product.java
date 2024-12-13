package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
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

    @ManyToOne
    @JoinColumn(name = "id_seller", nullable = false)
    private Seller seller;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
