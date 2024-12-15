package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product.CartProduct;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartProductDTO {

    private Long id;
    private Order order;
    private ProductDTO product;
    private Long quantity;


    public CartProductDTO() {}

    public CartProductDTO(CartProduct cartProduct) {
        this.id = cartProduct.getId();
        this.order = cartProduct.getOrder();
        this.product = new ProductDTO(cartProduct.getProduct());
        this.quantity = cartProduct.getQuantity();
    }
}
