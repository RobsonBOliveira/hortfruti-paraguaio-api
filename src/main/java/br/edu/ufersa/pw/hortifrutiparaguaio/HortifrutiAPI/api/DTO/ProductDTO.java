package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public ProductDTO(Product product) {
        this.productId = product.getId().getProductId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
