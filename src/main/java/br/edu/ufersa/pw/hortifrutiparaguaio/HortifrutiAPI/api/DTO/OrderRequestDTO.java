package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.CartProduct;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrderRequestDTO {
        private ClientDTO client;
        private List<CartProduct> cartProducts = new ArrayList<>();
}
