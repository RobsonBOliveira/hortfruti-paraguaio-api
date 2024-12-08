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
    @EmbeddedId
    private CartProductPK id;

    @ManyToOne
    @MapsId("id_cart")
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name = "id_product")
    private Product product;

    private long quantity;
}
