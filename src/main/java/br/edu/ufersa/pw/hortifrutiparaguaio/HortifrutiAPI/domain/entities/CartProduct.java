package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_cart_products")
@Getter
@Setter
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false),
            @JoinColumn(name = "id_seller", referencedColumnName = "id_seller", nullable = false)
    })
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Long quantity;
}
