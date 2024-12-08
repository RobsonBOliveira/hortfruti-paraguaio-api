package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart.Cart;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "tb_cart_products")
@Getter
@Setter
@Entity
public class CartProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fakeId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_product")
    private Product product;

    private long quantity;
}
