package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.CartProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartProductDTO {
    private Long id;
    private OrderDTO order;
    private ProductDTO product;
    private Long quantity;

    public CartProductDTO() {
    }

    public CartProductDTO(CartProduct cartProduct) {
        this.id = cartProduct.getId();
        this.order = new OrderDTO(cartProduct.getOrder());
        this.product = new ProductDTO(cartProduct.getProduct());
        this.quantity = cartProduct.getQuantity();
    }

    public List<CartProductDTO> listCartProducts(List<CartProduct> cartProducts) {
        return cartProducts.stream()
                .map(CartProductDTO::new)
                .collect(Collectors.toList());
    }
}
