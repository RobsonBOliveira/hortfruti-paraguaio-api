package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class CartProductPK implements Serializable {

    private long id_cart;
    private long id_product;

    public CartProductPK() {}

    public CartProductPK(long id_cart, long id_product) {
        this.id_cart = id_cart;
        this.id_product = id_product;
    }
}
