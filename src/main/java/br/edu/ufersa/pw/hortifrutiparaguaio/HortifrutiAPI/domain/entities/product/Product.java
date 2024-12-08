package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart.Cart;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_product")
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_seller", referencedColumnName = "id", nullable = false)
    private Seller idSeller;

    @OneToMany(mappedBy = "tb_product", cascade = CascadeType.ALL)
    private Set<Product> products;

    private String name;

    private String image;

    private String description;

    private double price;

    private int quantity;
}
