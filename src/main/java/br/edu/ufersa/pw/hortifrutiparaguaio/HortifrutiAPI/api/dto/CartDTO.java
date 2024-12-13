package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart.Cart;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product.CartProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter

public class CartDTO {

    private Long id;
    private ClientDTO client;
    private Set<CartProduct> cartProducts;

    public CartDTO(Cart cart) {
        this.id = cart.getId();
        this.client = new ClientDTO(cart.getClient());
        this.cartProducts = cart.getCartProducts();
    }
}
