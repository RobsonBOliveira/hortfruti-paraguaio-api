package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product.CartProduct;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequestDTO {

        private ClientDTO client;
        private CartProduct cartProduct;

}
